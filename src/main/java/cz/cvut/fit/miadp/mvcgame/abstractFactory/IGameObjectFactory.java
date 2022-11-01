package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public interface IGameObjectFactory {

    public AbsCannon createCannon( );
    public AbsMissile createMissile( Position cannonPosition );
    //createEnemy( );
    
}
