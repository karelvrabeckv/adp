package cz.cvut.fit.miadp.mvcgame.model;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public interface IGameModel extends IObservable {
    public void update( );
    public Position getCannonPosition( );
    public void moveCannonUp( );
    public void moveCannonDown( );
    public void aimCannonUp( );
    public void aimCannonDown( );
    public void cannonPowerUp( );
    public void cannonPowerDown( );
    public void cannonShoot( );
    public List<AbsMissile> getMissiles( );
    public List<GameObject> getGameObjects( );
    public IMovingStrategy getMovingStrategy( );
    public void toggleMovingStrategy( );
    public void toggleShootingMode( );
    public Object createMemento( );
    public void setMemento( Object memento );

    public void registerCommand( AbstractGameCommand cmd );
    public void undoLastCommand( );
}
