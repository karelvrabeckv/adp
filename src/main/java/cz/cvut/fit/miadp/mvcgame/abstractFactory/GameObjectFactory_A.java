package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A.*;

import java.util.Random;

public class GameObjectFactory_A implements IGameObjectFactory {

    private IGameModel model;

    public GameObjectFactory_A( IGameModel model ){
        this.model = model;
    }

    @Override
    public Cannon_A createCannon( ) {
        return new Cannon_A( new Position( MvcGameConfig.CANNON_X, MvcGameConfig.CANNON_Y ), this );
    }

    @Override
    public Missile_A createMissile( double initAngle, int initVelocity ) {
        return new Missile_A( 
            new Position(
                model.getCannon( ).getPosition( ).getX( ),
                model.getCannon( ).getPosition( ).getY( )
            ),
            initAngle, 
            initVelocity, 
            this.model.getGameInfo( ).getMovingStrategy( )
        );
    }

    @Override
    public Enemy_A createEnemy( ) {
        Random random = new Random( );

        int x = random.nextInt(MvcGameConfig.MAX_X_BOUND - MvcGameConfig.MIN_X_BOUND + 1) + MvcGameConfig.MIN_X_BOUND;
        int y = random.nextInt(MvcGameConfig.MAX_Y_BOUND - MvcGameConfig.MIN_Y_BOUND + 1) + MvcGameConfig.MIN_Y_BOUND;

        int type = random.nextInt( MvcGameConfig.NUM_OF_ENEMY_TYPES );

        return new Enemy_A( new Position( x, y ), type, this );
    }

    @Override
    public Collision_A createCollision( Position position ) {
        return new Collision_A( position );
    }

    @Override
    public GameInfo_A createGameInfo( ) {
        return new GameInfo_A( new Position( MvcGameConfig.GAME_INFO_POS_X, MvcGameConfig.GAME_INFO_POS_Y ), model );
    }

    @Override
    public Obstacle_A createObstacle() {
        Random random = new Random( );

        int x = random.nextInt(MvcGameConfig.MAX_X_BOUND - MvcGameConfig.MIN_X_BOUND + 1) + MvcGameConfig.MIN_X_BOUND;
        int y = random.nextInt(MvcGameConfig.MAX_Y_BOUND - MvcGameConfig.MIN_Y_BOUND + 1) + MvcGameConfig.MIN_Y_BOUND;

        return new Obstacle_A( new Position( x, y ) );
    }

    @Override
    public Bomb_A createBomb() {
        Random random = new Random( );

        int x = random.nextInt(MvcGameConfig.MAX_X_BOUND - MvcGameConfig.MIN_X_BOUND + 1) + MvcGameConfig.MIN_X_BOUND;
        int y = random.nextInt(MvcGameConfig.MAX_Y_BOUND - MvcGameConfig.MIN_Y_BOUND + 1) + MvcGameConfig.MIN_Y_BOUND;

        return new Bomb_A( new Position( x, y ), this );
    }

}
