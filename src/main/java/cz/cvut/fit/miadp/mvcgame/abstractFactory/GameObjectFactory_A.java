package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A.Missile_A;

public class GameObjectFactory_A implements IGameObjectFactory {

    @Override
    public Cannon_A createCannon() {
        return new Cannon_A( new Position( MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y ), this );
    }

    @Override
    public Missile_A createMissile( Position cannonPosition ) {
        return new Missile_A( cannonPosition );
    }
    
}
