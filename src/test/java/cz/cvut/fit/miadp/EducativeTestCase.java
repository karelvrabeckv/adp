package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.command.*;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsBomb;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsObstacle;
import org.junit.Assert;
import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class EducativeTestCase {

    @Test
    public void undoTest( ) {
        IGameModel model = new GameModel( );

        Position firstPos = model.getCannon( ).getPosition( ).clone( );

        model.registerCommand( new MoveCannonRightCmd( model ) );
        model.update( );
        model.undoLastCommand( );

        Position secondPos = model.getCannon( ).getPosition( ).clone( );

        Assert.assertEquals( firstPos.getX( ), secondPos.getX( ) );
        Assert.assertEquals( firstPos.getY( ), secondPos.getY( ) );
    }

    @Test
    public void restartTest( ) {
        IGameModel model = new GameModel( );

        model.registerCommand( new MoveCannonRightCmd( model ) );
        model.update( );
        model.restart( );

        Assert.assertEquals( model.getCannon( ).getPosition( ).getX( ), MvcGameConfig.CANNON_X );
        Assert.assertEquals( model.getCannon( ).getPosition( ).getY( ), MvcGameConfig.CANNON_Y );
    }

    @Test
    public void powerCannonTest( ) {
        IGameModel model = new GameModel( );

        int firstPower = model.getCannon( ).getPower( );

        model.registerCommand( new PowerCannonUpCmd( model ) );
        model.update( );

        int secondPower = model.getCannon( ).getPower( );

        model.registerCommand( new PowerCannonDownCmd( model ) );
        model.update( );

        int thirdPower = model.getCannon( ).getPower( );

        Assert.assertEquals( firstPower, secondPower - MvcGameConfig.CANNON_POWER_STEP );
        Assert.assertEquals( secondPower, thirdPower + MvcGameConfig.CANNON_POWER_STEP );
        Assert.assertEquals( firstPower, thirdPower );
    }

    @Test
    public void boundsTest( ) {
        IGameModel model = new GameModel( );
        IGameObjectFactory factory = new GameObjectFactory_A( model );

        AbsEnemy enemy = factory.createEnemy( );

        Assert.assertTrue( MvcGameConfig.MIN_X_BOUND <= enemy.getPosition( ).getX( ) );
        Assert.assertTrue( enemy.getPosition( ).getX( ) <= MvcGameConfig.MAX_X_BOUND );

        Assert.assertTrue( MvcGameConfig.MIN_Y_BOUND <= enemy.getPosition( ).getY( ) );
        Assert.assertTrue( enemy.getPosition( ).getY( ) <= MvcGameConfig.MAX_Y_BOUND );

        AbsBomb bomb = factory.createBomb( );

        Assert.assertTrue( MvcGameConfig.MIN_X_BOUND <= bomb.getPosition( ).getX( ) );
        Assert.assertTrue( bomb.getPosition( ).getX( ) <= MvcGameConfig.MAX_X_BOUND );

        Assert.assertTrue( MvcGameConfig.MIN_Y_BOUND <= bomb.getPosition( ).getY( ) );
        Assert.assertTrue( bomb.getPosition( ).getY( ) <= MvcGameConfig.MAX_Y_BOUND );

        AbsObstacle obstacle = factory.createObstacle( );

        Assert.assertTrue( MvcGameConfig.MIN_X_BOUND <= obstacle.getPosition( ).getX( ) );
        Assert.assertTrue( obstacle.getPosition( ).getX( ) <= MvcGameConfig.MAX_X_BOUND );

        Assert.assertTrue( MvcGameConfig.MIN_Y_BOUND <= obstacle.getPosition( ).getY( ) );
        Assert.assertTrue( obstacle.getPosition( ).getY( ) <= MvcGameConfig.MAX_Y_BOUND );
    }

}
