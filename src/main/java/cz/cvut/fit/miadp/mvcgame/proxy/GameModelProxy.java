package cz.cvut.fit.miadp.mvcgame.proxy;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

public class GameModelProxy implements IGameModel {

    private IGameModel subject;

    public GameModelProxy( IGameModel model ){
        this.subject = model;
    }

    @Override
    public void registerObserver( IObserver obs ) {
        this.subject.registerObserver( obs );
    }

    @Override
    public void unregisterObserver( IObserver obs ) {
        this.subject.unregisterObserver( obs );
    }

    @Override
    public void notifyObservers( ) {
        this.subject.notifyObservers( );
    }

    @Override
    public void update( ) {
        this.subject.update( );
    }

    @Override
    public AbsCannon getCannon( ) { return subject.getCannon( ); }

    @Override
    public void moveCannonLeft( ) {
        this.subject.moveCannonLeft( );
    }

    @Override
    public void moveCannonRight( ) {
        this.subject.moveCannonRight( );
    }

    @Override
    public void aimCannonUp( ) {
        this.subject.aimCannonUp( );
    }

    @Override
    public void aimCannonDown( ) {
        this.subject.aimCannonDown( );
    }

    @Override
    public void cannonPowerUp( ) {
        this.subject.cannonPowerUp( );
    }

    @Override
    public void cannonPowerDown( ) {
        this.subject.cannonPowerDown( );
    }

    @Override
    public void cannonShoot( ) {
        this.subject.cannonShoot( );
    }

    @Override
    public List<AbsMissile> getMissiles( ) {
        return this.subject.getMissiles( );
    }

    @Override
    public List<AbsEnemy> getEnemies() {
        return this.subject.getEnemies( );
    }

    @Override
    public List<AbsObstacle> getObstacles() {
        return subject.getObstacles( );
    }

    @Override
    public List<AbsBomb> getBombs() {
        return subject.getBombs( );
    }

    @Override
    public List<AbsCollision> getCollisions() {
        return this.subject.getCollisions( );
    }

    @Override
    public List<GameObject> getGameObjects( ) {
        return this.subject.getGameObjects( );
    }

    @Override
    public AbsGameInfo getGameInfo() {
        return this.subject.getGameInfo( );
    }

    @Override
    public void toggleMovingStrategy( ) {
        this.subject.toggleMovingStrategy( );
    }

    @Override
    public void toggleShootingMode( ) {
        this.subject.toggleShootingMode( );
    }

    @Override
    public Object createMemento( ) {
        return this.subject.createMemento( );
    }

    @Override
    public void setMemento( Object memento ) {
        this.subject.setMemento( memento );
    }

    @Override
    public void registerCommand( AbstractGameCommand cmd ) {
        this.subject.registerCommand( cmd );
    }

    @Override
    public void undoLastCommand( ) {
        this.subject.undoLastCommand( );
    }
    
}
