package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;

public interface IGameObjectFactory {

    public AbsCannon createCannon( );
    public AbsMissile createMissile( double initAngle, int initVelocity );
    public AbsEnemy createEnemy( );
    public AbsCollision createCollision( Position position );

    // TODO createGameInfo( ... );

}
