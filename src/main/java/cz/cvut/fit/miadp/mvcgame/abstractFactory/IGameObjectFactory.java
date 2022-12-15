package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

public interface IGameObjectFactory {

    public AbsCannon createCannon( );
    public AbsMissile createMissile( double initAngle, int initVelocity );
    public AbsEnemy createEnemy( );
    public AbsCollision createCollision( Position position );
    public AbsGameInfo createGameInfo( );

}
