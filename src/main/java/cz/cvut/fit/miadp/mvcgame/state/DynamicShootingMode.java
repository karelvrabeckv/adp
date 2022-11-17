package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;

public class DynamicShootingMode implements IShootingMode {

    @Override
    public void shoot( AbsCannon cannon ) {
        for ( int i = 0; i < ( int ) Math.floor( cannon.getNumOfMissiles( ) / 2.0 ); i++ ) {
            cannon.aimUp( );
        }

        for ( int i = 0; i < cannon.getNumOfMissiles( ); i++ ) {
            cannon.primitiveShoot( );
            cannon.aimDown( );
        }

        for ( int i = 0; i < ( int ) Math.ceil( cannon.getNumOfMissiles( ) / 2.0 ); i++ ) {
            cannon.aimUp( );
        }
    }

    @Override
    public String getName( ) {
        return "DynamicShootingMode";
    }
    
}
