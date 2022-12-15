package cz.cvut.fit.miadp.mvcgame.model;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;

public interface IGameModel extends IObservable {
    public void update( );

    public List<GameObject> getGameObjects( );

    public AbsCannon getCannon( );
    public List<AbsMissile> getMissiles( );
    public List<AbsEnemy> getEnemies( );
    public List<AbsObstacle> getObstacles( );
    public List<AbsBomb> getBombs( );
    public List<AbsCollision> getCollisions( );
    public AbsGameInfo getGameInfo( );

    public void toggleMovingStrategy( );
    public void toggleShootingMode( );

    public void moveCannonLeft( );
    public void moveCannonRight( );
    public void aimCannonUp( );
    public void aimCannonDown( );
    public void cannonPowerUp( );
    public void cannonPowerDown( );
    public void cannonShoot( );

    public Object createMemento( );
    public void setMemento( Object memento );

    public void registerCommand( AbstractGameCommand cmd );
    public void undoLastCommand( );
}
