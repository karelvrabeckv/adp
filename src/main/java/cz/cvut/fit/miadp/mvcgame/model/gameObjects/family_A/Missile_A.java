package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class Missile_A extends AbsMissile {

    private IMovingStrategy movingStrategy;

    public Missile_A( Position position, double angle, int velocity, IMovingStrategy movingStrategy ) {
        super( position, angle, velocity );
        this.movingStrategy = movingStrategy;
    }

    public Missile_A( Missile_A missile ) {
        super( missile.position.clone( ), missile.angle, missile.velocity );
        movingStrategy = missile.movingStrategy;
    }

    @Override
    public void move( ) {
        this.movingStrategy.updatePosition( this );
    }

    @Override
    public AbsMissile clone( ) {
        return new Missile_A( this );
    }

}
