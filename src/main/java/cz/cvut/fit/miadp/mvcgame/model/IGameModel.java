package cz.cvut.fit.miadp.mvcgame.model;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.builder.Difficulty;
import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;

public interface IGameModel extends IObservable {
    public void changeDifficulty( String difficulty );
    public void restart( );
    public void update( );

    public List<GameObject> getGameObjects( );

    public Difficulty getDifficulty( );
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
    public void powerCannonUp( );
    public void powerCannonDown( );
    public void cannonShoot( );

    public Object createMemento( );
    public void setMemento( Object memento );
    public IGameModel clone( );

    public void registerCommand( AbstractGameCommand cmd );
    public void undoLastCommand( );
}
