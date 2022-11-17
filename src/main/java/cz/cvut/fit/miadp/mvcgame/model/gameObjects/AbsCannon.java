package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.DynamicShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsCannon extends GameObject {

    protected IShootingMode shootingMode;
    protected static IShootingMode SINGLE_SHOOTING_MODE = new SingleShootingMode( );
    protected static IShootingMode DOUBLE_SHOOTING_MODE = new DoubleShootingMode( );
    protected static IShootingMode DYNAMIC_SHOOTING_MODE = new DynamicShootingMode( );

    public abstract void moveUp( );
    public abstract void moveDown( );
    public abstract void aimUp( );
    public abstract void aimDown( );
    public abstract void powerUp( );
    public abstract void powerDown( );

    public abstract List<AbsMissile> shoot( );
    public abstract void primitiveShoot( );
    public abstract void increaseNumOfMissiles( );
    public abstract void decreaseNumOfMissiles( );
    public abstract int getNumOfMissiles( );

    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitCannon( this );
    }

    public void toggleShootingMode( ) {
        if ( this.shootingMode instanceof SingleShootingMode ) {
            this.shootingMode = DOUBLE_SHOOTING_MODE;
        }
        else if ( this.shootingMode instanceof DoubleShootingMode ) {
            this.shootingMode = DYNAMIC_SHOOTING_MODE;
        }
        else if ( this.shootingMode instanceof DynamicShootingMode ) {
            this.shootingMode = SINGLE_SHOOTING_MODE;
        }
        else {

        }
    }

}
