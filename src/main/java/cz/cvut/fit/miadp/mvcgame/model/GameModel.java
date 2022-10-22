package cz.cvut.fit.miadp.mvcgame.model;

import java.util.HashMap;
import java.util.Map;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.Cannon;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

public class GameModel implements IObservable {

    private Cannon cannon;
    private Map<IObserver, Aspect> observers;

    public GameModel( ) {
        this.cannon = new Cannon( new Vector( MvcGameConfig.CANNON_POS[0], MvcGameConfig.CANNON_POS[1] ) );
        this.observers = new HashMap<IObserver, Aspect>( );
    }

    public void update( ) {
        //this.moveMissiles
        //destroyDeathEnemies
    }

    public Vector getCannonPosition( ) {
        return this.cannon.getPosition( );
    }

    public void moveCannonUp( ) {
        this.cannon.moveUp( );

        this.notifyObservers( new Aspect( MvcGameConfig.OBSERVABLE_PROP_CHANGE ) );
    }

    public void moveCannonDown( ) {
        this.cannon.moveDown( );

        this.notifyObservers( new Aspect( MvcGameConfig.OBSERVABLE_PROP_CHANGE ) );
    }

    @Override
    public void registerObserver( IObserver observer, Aspect aspect ) {
        this.observers.put( observer, aspect );
    }

    @Override
    public void unregisterObserver( IObserver observer ) {
        this.observers.remove( observer );
    }

    @Override
    public void notifyObservers( Aspect aspect ) {
        for ( Map.Entry<IObserver, Aspect> pair : this.observers.entrySet( ) ) {
            // update observers registered to the invoked action
            if ( pair.getValue( ).getName( ).equals( aspect.getName() ) ) {
                pair.getKey( ).update( aspect );
            }
        }
    }

}
