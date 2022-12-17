package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A.GameInfo_A;
import org.junit.Assert;
import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

import static org.mockito.Mockito.*;

public class EducativeMockTestCase {

    @Test
    public void createMissileTest( ){
        IGameModel model = mock( GameModel.class );
        IGameObjectFactory factory = new GameObjectFactory_A( model );

        when( model.getCannon( ) ).thenReturn( new Cannon_A( new Position( 500, 500 ), factory ) );
        when( model.getGameInfo( ) ).thenReturn( new GameInfo_A( new Position( 0, 0 ), model ) );

        AbsMissile missile = factory.createMissile( 0, 0 );

        Assert.assertEquals( missile.getPosition( ).getX( ), 500 );
        Assert.assertEquals( missile.getPosition( ).getY( ), 500 );
    }

    @Test
    public void moveCannonTest( ) {
        IGameModel model = mock( GameModel.class );
        IGameObjectFactory factory = new GameObjectFactory_A( model );

        when( model.getCannon( ) ).thenReturn( new Cannon_A( new Position( 500, 500 ), factory ) );

        doAnswer( invocationOnMock -> {
            model.getCannon( ).moveRight( );
            return null;
        }).when( model ).moveCannonRight( );

        doAnswer( invocationOnMock -> {
            model.getCannon( ).moveLeft( );
            return null;
        }).when( model ).moveCannonLeft( );

        Position firstPos = model.getCannon( ).getPosition( ).clone( );

        model.moveCannonRight( );

        Position secondPos = model.getCannon( ).getPosition( ).clone( );

        model.moveCannonLeft( );

        Position thirdPos = model.getCannon( ).getPosition( ).clone( );

        Assert.assertEquals( firstPos.getX( ), secondPos.getX( ) - MvcGameConfig.CANNON_MOVE_STEP );
        Assert.assertEquals( firstPos.getY( ), secondPos.getY( ) );

        Assert.assertEquals( secondPos.getX( ), thirdPos.getX( ) + MvcGameConfig.CANNON_MOVE_STEP );
        Assert.assertEquals( secondPos.getY( ), thirdPos.getY( ) );

        Assert.assertEquals( firstPos.getX( ), thirdPos.getX( ) );
        Assert.assertEquals( firstPos.getY( ), thirdPos.getY( ) );
    }

}
