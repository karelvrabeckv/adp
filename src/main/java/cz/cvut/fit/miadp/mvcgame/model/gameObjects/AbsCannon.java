package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsCannon extends GameObject {

    protected IShootingMode shootingMode;
    protected static IShootingMode SINGLE_SHOOTING_MODE = new SingleShootingMode( );
    protected static IShootingMode DOUBLE_SHOOTING_MODE = new DoubleShootingMode( );

    public abstract double getAngle( );
    public abstract int getPower( );
    public abstract void moveLeft( );
    public abstract void moveRight( );
    public abstract void aimUp( );
    public abstract void aimDown( );
    public abstract void powerUp( );
    public abstract void powerDown( );

    public abstract List<AbsMissile> shoot( );
    public abstract void primitiveShoot( );

    public IShootingMode getShootingMode( ) { return shootingMode; }

    public void toggleShootingMode( ) {
        if ( this.shootingMode instanceof SingleShootingMode ) {
            this.shootingMode = DOUBLE_SHOOTING_MODE;
        }
        else if ( this.shootingMode instanceof DoubleShootingMode ) {
            this.shootingMode = SINGLE_SHOOTING_MODE;
        }
        else {

        }
    }

    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitCannon( this );
    }

}
