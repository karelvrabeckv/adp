package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class SineMovingStrategy implements IMovingStrategy {

    @Override
    public void updatePosition( AbsMissile missile ) {
        double initAngle = missile.getInitAngle( );
        int initVelocity = missile.getInitVelocity( );
        long time = missile.getAge( ) / 100;

        int dX = ( int )( initVelocity * Math.cos( initAngle ) );
        int dY = ( int )( initVelocity * Math.sin( initAngle ) + ( initVelocity * Math.sin( time + Math.PI / 2 ) ) );

        missile.move( new Vector( dX, dY ) );
    }
    
}
