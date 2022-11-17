package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class SpringMovingStrategy implements IMovingStrategy {

    @Override
    public void updatePosition( AbsMissile missile ) {
        int initVelocity = missile.getInitVelocity( );
        long time = missile.getAge( ) / 100;

        int dX = ( int )( initVelocity * Math.cos( time ) + initVelocity );
        int dY = ( int )( initVelocity * Math.sin( time ) );

        missile.move( new Vector( dX, dY ) );
    }
    
}
