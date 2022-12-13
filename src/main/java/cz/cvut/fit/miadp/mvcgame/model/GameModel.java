package cz.cvut.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;

public class GameModel implements IGameModel {

    private AbsCannon cannon;
    private List<AbsMissile> missiles;
    private List<AbsEnemy> enemies;

    private List<IObserver> observers;
    private IGameObjectFactory factory;
    private IMovingStrategy movingStrategy;

    private int score;

    private Queue<AbstractGameCommand> unExecutedCmds;
    private Stack<AbstractGameCommand> executedCmds;

    public GameModel( ) {
        this.observers = new ArrayList<IObserver>( );
        this.factory = new GameObjectFactory_A( this );
        this.cannon = this.factory.createCannon( );
        this.missiles = new ArrayList<AbsMissile>();
        this.enemies = this.createEnemies();
        this.movingStrategy = new SimpleMovingStrategy( );   
        this.score = 0;
        this.unExecutedCmds = new LinkedBlockingQueue<AbstractGameCommand>( );
        this.executedCmds = new Stack<AbstractGameCommand>(); 
    }

    public List<AbsEnemy> createEnemies() {
        List<AbsEnemy> enemies = new ArrayList<AbsEnemy>( );

        for ( int i = 0; i < MvcGameConfig.NUM_OF_ENEMIES; i++ ) {
            enemies.add( this.factory.createEnemy( ) );
        }

        return enemies;
    }

    public void update( ) {
        this.executedCmds( );
        this.moveMissiles( );
    }

    private void executedCmds( ) {
        while( !this.unExecutedCmds.isEmpty( ) ){
            AbstractGameCommand cmd = this.unExecutedCmds.poll( );
            cmd.doExecute( );
            this.executedCmds.push( cmd );
        }
    }

    private void moveMissiles( ) {
        for ( AbsMissile missile : this.missiles ) {
            missile.move(  );
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
        this.notifyObservers( );
    }

    public void moveCannonDown( ) {
        this.cannon.moveDown( );
        this.notifyObservers( );
    }

    public void aimCannonUp( ) {
        this.cannon.aimUp( );
        this.notifyObservers( );
    }

    public void aimCannonDown( ) {
        this.cannon.aimDown( );
        this.notifyObservers( );
    }

    public void cannonPowerUp( ) {
        this.cannon.powerUp( );
        this.notifyObservers( );
    }

    public void cannonPowerDown( ) {
        this.cannon.powerDown( );
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
        this.missiles.addAll( cannon.shoot( ) ) ;
        this.notifyObservers( );
    }

    public List<AbsMissile> getMissiles( ) {
        return this.missiles;
    }

    public List<GameObject> getGameObjects( ) {
        List<GameObject> gameObjects = new ArrayList<GameObject>( );

        gameObjects.add( this.cannon );
        gameObjects.addAll( this.missiles );
        gameObjects.addAll( this.enemies );

        return gameObjects;
    }

    public IMovingStrategy getMovingStrategy( ){
        return this.movingStrategy;
    }

    public void toggleMovingStrategy( ) {
        if ( this.movingStrategy instanceof SimpleMovingStrategy ) {
            this.movingStrategy = new RealisticMovingStrategy( );
        }
        else if ( this.movingStrategy instanceof RealisticMovingStrategy ){
            this.movingStrategy = new SimpleMovingStrategy( );
        }
        else {

        }
    }

    public void toggleShootingMode( ){
        this.cannon.toggleShootingMode( );
    }

    private class Memento {
        private int score;
        private int cannonX;
        private int cannonY;
        // GO positions
    }

    public Object createMemento( ) {
        Memento m = new Memento( );
        m.score = this.score;
        m.cannonX = this.getCannonPosition( ).getX( );
        m.cannonY = this.getCannonPosition( ).getY( );
        return m;
    }

    public void setMemento( Object memento ) {
        Memento m = ( Memento ) memento;
        this.score = m.score;
        this.cannon.getPosition( ).setX( m.cannonX );
        this.cannon.getPosition( ).setY( m.cannonY );
    }

    @Override
    public void registerCommand( AbstractGameCommand cmd ) {
        this.unExecutedCmds.add( cmd );
    }

    @Override
    public void undoLastCommand( ) {
        if( !this.executedCmds.isEmpty( ) ){
            AbstractGameCommand cmd = this.executedCmds.pop( );
            cmd.unExecute( );
        }
        this.notifyObservers( );
    }

}
