package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class Missile_A extends AbsMissile {

    private IMovingStrategy movingStrategy;

    public Missile_A( Position initialPosition, double initAngle, int initVelocity, IMovingStrategy movingStrategy ){
        super( initialPosition, initAngle, initVelocity);
        this.position = initialPosition;
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void move( ) {
        this.movingStrategy.updatePosition( this );
    }

}
