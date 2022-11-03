package cz.cvut.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjectFactory_B;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameAudio;

public class GameModel implements IObservable {

    private AbsCannon cannon;
    private List<AbsMissile> missiles;
    private List<IObserver> observers;
    private IGameObjectFactory goFact;
    private GameAudio audio;

    public GameModel( ) {
        this.observers = new ArrayList<IObserver>( );
        this.goFact = new GameObjectFactory_B( );
        this.cannon = this.goFact.createCannon( );   
        this.missiles = new ArrayList<AbsMissile>();
        this.audio = new GameAudio( );
    }

    public void update( ) {
        this.moveMissiles( );
    }

    private void moveMissiles( ) {
        for ( AbsMissile missile : this.missiles ) {
            missile.fly();
        }
        this.destroyMissiles( );
        this.notifyObservers( );
    }

    private void destroyMissiles( ) {
        List<AbsMissile> missilesToRemove = new ArrayList<AbsMissile>();
        for ( AbsMissile missile : this.missiles ) {
            if( missile.getPosition( ).getX( ) > MvcGameConfig.MAX_X ) {
                missilesToRemove.add( missile );
            }
        }
        this.missiles.removeAll(missilesToRemove);
    }

    public Position getCannonPosition( ) {
        return this.cannon.getPosition( );
    }

    public void moveCannonUp( ) {
        this.cannon.moveUp( );
        this.cannon.acceptVisitor( this.audio );
        this.notifyObservers( );
    }

    public void moveCannonDown( ) {
        this.cannon.moveDown( );
        this.cannon.acceptVisitor( this.audio );
        this.notifyObservers( );
    }

    @Override
    public void registerObserver( IObserver obs ) {
        if( !this.observers.contains( obs ) ) {
            this.observers.add( obs );
        }
    }

    @Override
    public void unregisterObserver( IObserver obs ) {
        if( this.observers.contains( obs ) ) {
            this.observers.remove( obs );
        }
    }

    @Override
    public void notifyObservers( ) {
        for( IObserver obs : this.observers ){
            obs.update( );
        }
    }

    public void cannonShoot( ) {
        AbsMissile missile = cannon.shoot( );
        missile.acceptVisitor( this.audio );
        this.missiles.add( missile ) ;
        this.notifyObservers( );
    }

    public List<AbsMissile> getMissiles( ) {
        return this.missiles;
    }

    public List<GameObject> getGameObjects( ) {
        List<GameObject> go = new ArrayList<GameObject>();
        go.add( this.cannon );
        go.addAll( this.missiles );
        return go;
    }

}