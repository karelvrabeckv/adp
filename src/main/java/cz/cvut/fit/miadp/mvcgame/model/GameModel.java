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
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

public class GameModel implements IGameModel {

    private List<IObserver> observers;
    private IGameObjectFactory factory;

    private AbsCannon cannon;
    private List<AbsMissile> missiles;
    private List<AbsEnemy> enemies;
    private List<AbsCollision> collisions;
    private AbsGameInfo gameInfo;

    private Queue<AbstractGameCommand> unexecutedCommands;
    private Stack<AbstractGameCommand> executedCommands;

    public GameModel( ) {
        this.observers = new ArrayList<IObserver>( );
        this.factory = new GameObjectFactory_A( this );

        this.cannon = this.factory.createCannon( );
        this.missiles = new ArrayList<AbsMissile>( );
        this.enemies = this.createEnemies( );
        this.collisions = new ArrayList<AbsCollision>( );
        this.gameInfo = this.factory.createGameInfo( );

        this.unexecutedCommands = new LinkedBlockingQueue<AbstractGameCommand>( );
        this.executedCommands = new Stack<AbstractGameCommand>( );
    }

    private List<AbsEnemy> createEnemies( ) {
        List<AbsEnemy> enemies = new ArrayList<AbsEnemy>( );

        for ( int i = 0; i < MvcGameConfig.NUM_OF_ENEMIES; i++ ) {
            enemies.add( this.factory.createEnemy( ) );
        }

        return enemies;
    }

//    private GameInfo createGameInfo( ) {
//        Director director = new Director( );
//        GameInfoBuilder builder = new GameInfoBuilder( );
//
//        director.constructVerboseBuilder( builder );
//
//        return builder.getProduct( );
//    }

    public void update( ) {
        this.executedCommands( );

        this.moveMissiles( );
        this.destroyMissilesAndEnemies( );
        this.destroyCollisions( );

        this.notifyObservers( );
    }

    private void executedCommands( ) {
        while( !this.unexecutedCommands.isEmpty( ) ){
            AbstractGameCommand cmd = this.unexecutedCommands.poll( );
            cmd.doExecute( );
            this.executedCommands.push( cmd );
        }
    }

    private void moveMissiles( ) {
        for ( AbsMissile missile : missiles ) {
            missile.move( );
        }
    }

    private void destroyMissilesAndEnemies( ) {
        List<AbsMissile> missilesToRemove = new ArrayList<AbsMissile>( );
        List<AbsEnemy> enemiesToRemove = new ArrayList<AbsEnemy>( );

        for ( AbsMissile missile : missiles ) {
            // check the bound x
            if ( missile.getPosition( ).getX( ) < 0 || missile.getPosition( ).getX( ) > MvcGameConfig.SCREEN_X ) {
                missilesToRemove.add( missile );
            }

            // check the bound y
            if ( missile.getPosition( ).getY( ) < 0 || missile.getPosition( ).getY( ) > MvcGameConfig.SCREEN_Y ) {
                missilesToRemove.add( missile );
            }

            // check the collisions with enemies
            for ( AbsEnemy enemy : enemies ) {
                if ( missile.getDistanceTo( enemy ) < MvcGameConfig.COLLISION_DISTANCE ) {
                    collisions.add( enemy.explode( ) ) ;
                    gameInfo.setScore( gameInfo.getScore() + 1 );

                    missilesToRemove.add( missile );
                    enemiesToRemove.add( enemy );
                }
            }
        }

        missiles.removeAll( missilesToRemove );
        enemies.removeAll( enemiesToRemove );
    }

    private void destroyCollisions( ) {
        List<AbsCollision> collisionsToRemove = new ArrayList<AbsCollision>( );

        for ( AbsCollision collision : collisions ) {
            if ( collision.getAge() > MvcGameConfig.COLLISION_AGE ) {
                collisionsToRemove.add( collision );
                enemies.add( factory.createEnemy( ) );
            }
        }

        collisions.removeAll( collisionsToRemove );
    }

    public List<GameObject> getGameObjects( ) {
        List<GameObject> gameObjects = new ArrayList<GameObject>( );

        gameObjects.add( cannon );
        gameObjects.addAll( missiles );
        gameObjects.addAll( enemies );
        gameObjects.addAll( collisions );
        gameObjects.add( gameInfo );

        return gameObjects;
    }

    public AbsCannon getCannon( ) { return cannon; }
    public List<AbsMissile> getMissiles( ) {
        return this.missiles;
    }
    public List<AbsEnemy> getEnemies( ) {
        return this.enemies;
    }
    public List<AbsCollision> getCollisions( ) {
        return this.collisions;
    }
    public AbsGameInfo getGameInfo( ) {
        return gameInfo;
    }

    public void toggleMovingStrategy( ) {
        this.gameInfo.toggleMovingStrategy( );
    }
    public void toggleShootingMode( ){
        this.cannon.toggleShootingMode( );
    }

    public void moveCannonLeft( ) {
        this.cannon.moveLeft( );

        this.notifyObservers( );
    }

    public void moveCannonRight( ) {
        this.cannon.moveRight( );

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

    public void cannonShoot( ) {
        List<AbsMissile> newMissiles = cannon.shoot( );
        this.missiles.addAll( newMissiles ) ;
        this.gameInfo.setUsedMissiles( this.gameInfo.getUsedMissiles() + newMissiles.size( ) );

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

    private class Memento {
        private int score;
        private int cannonX;
        private int cannonY;
        // GO positions
    }

    public Object createMemento( ) {
        Memento m = new Memento( );
        m.score = this.gameInfo.getScore();
        m.cannonX = this.getCannon( ).getPosition( ).getX( );
        m.cannonY = this.getCannon( ).getPosition( ).getY( );
        return m;
    }

    public void setMemento( Object memento ) {
        Memento m = ( Memento ) memento;
        this.gameInfo.setScore( m.score );
        this.cannon.getPosition( ).setX( m.cannonX );
        this.cannon.getPosition( ).setY( m.cannonY );
    }

    @Override
    public void registerCommand( AbstractGameCommand cmd ) {
        this.unexecutedCommands.add( cmd );
    }

    @Override
    public void undoLastCommand( ) {
        if( !this.executedCommands.isEmpty( ) ){
            AbstractGameCommand cmd = this.executedCommands.pop( );
            cmd.unExecute( );
        }
        this.notifyObservers( );
    }

}
