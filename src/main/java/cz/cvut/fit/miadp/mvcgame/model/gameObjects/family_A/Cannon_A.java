package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class Cannon_A extends AbsCannon {

    private IGameObjectFactory factory;
    private double angle;
    private int power;
    private List<AbsMissile> shootingBatch;

    public Cannon_A( Position initialPosition, IGameObjectFactory factory ) {
        this.position = initialPosition;
        this.factory = factory;
        this.power = MvcGameConfig.CANNON_INIT_POWER;
        this.angle = MvcGameConfig.CANNON_INIT_ANGLE;
        this.shootingMode = AbsCannon.SINGLE_SHOOTING_MODE;
        this.shootingBatch = new ArrayList<AbsMissile>();
    }

    @Override
    public double getAngle( ) { return angle; }

    @Override
    public int getPower( ) { return power; }

    @Override
    public void moveLeft( ) {
        if ( position.getX( ) - MvcGameConfig.CANNON_MOVE_STEP > MvcGameConfig.CANNON_L_BOUND ) {
            move( new Vector( -1 * MvcGameConfig.CANNON_MOVE_STEP, 0 ) );
        }
    }

    @Override
    public void moveRight( ) {
        if ( position.getX( ) + MvcGameConfig.CANNON_MOVE_STEP < MvcGameConfig.CANNON_R_BOUND ) {
            move( new Vector( MvcGameConfig.CANNON_MOVE_STEP, 0 ) );
        }
    }

    @Override
    public List<AbsMissile> shoot( ) {
        this.shootingBatch.clear( );
        this.shootingMode.shoot( this );
        return this.shootingBatch;
    }

    @Override
    public void aimUp() {
        if ( angle - MvcGameConfig.CANNON_ANGLE_STEP > -Math.PI ) {
            angle -= MvcGameConfig.CANNON_ANGLE_STEP;
        }
    }

    @Override
    public void aimDown() {
        if ( angle + MvcGameConfig.CANNON_ANGLE_STEP < 0 ) {
            angle += MvcGameConfig.CANNON_ANGLE_STEP;
        }
    }

    @Override
    public void powerUp() {
        if ( power + MvcGameConfig.CANNON_POWER_STEP < 25 ) {
            power += MvcGameConfig.CANNON_POWER_STEP;
        }
    }

    @Override
    public void powerDown() {
        if ( power - MvcGameConfig.CANNON_POWER_STEP > 0 ) {
            power -= MvcGameConfig.CANNON_POWER_STEP;
        }
    }

    @Override
    public void primitiveShoot() {
        this.shootingBatch.add( this.factory.createMissile( this.angle, this.power ) );
    }

}
