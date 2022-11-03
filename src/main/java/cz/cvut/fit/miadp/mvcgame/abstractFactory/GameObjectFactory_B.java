package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_B.Cannon_B;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_B.Missile_B;

public class GameObjectFactory_B implements IGameObjectFactory {

    @Override
    public Cannon_B createCannon( ) {
        return new Cannon_B( new Position( MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y ), this );
    }

    @Override
    public Missile_B createMissile( Position cannonPosition ) {
        return new Missile_B( cannonPosition );
    }
    
}
