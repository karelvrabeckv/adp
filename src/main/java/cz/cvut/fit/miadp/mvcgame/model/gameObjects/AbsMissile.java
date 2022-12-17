package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsMissile extends LifetimeLimitedGameObject {

    protected double angle;
    protected int velocity;

    protected AbsMissile( Position position, double angle, int velocity ) {
        super( position );
        this.angle = angle;
        this.velocity = velocity;
    }

    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitMissile( this );
    }

    public int getInitVelocity( ){
        return this.velocity;
    }

    public double getInitAngle( ) {
        return this.angle;
    }

    public abstract void move( );

    public abstract AbsMissile clone( );

}
