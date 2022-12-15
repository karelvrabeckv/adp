package cz.cvut.fit.miadp;

import org.junit.Assert;
import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonLeftCmd;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class EducativeTestCase {

    @Test
    public void undoCommandTest( ){
        IGameModel model = new GameModel( );
        int positionBeforeUndoX = model.getCannon( ).getPosition( ).getX( );
        int positionBeforeUndoY = model.getCannon( ).getPosition( ).getY( );
        model.registerCommand( new MoveCannonLeftCmd( model ) );
        model.update( );
        int positionAfterExcecution = model.getCannon( ).getPosition( ).getY( );
        model.undoLastCommand( );
        int positionAfterUndoX = model.getCannon( ).getPosition( ).getX( );
        int positionAfterUndoY = model.getCannon( ).getPosition( ).getY( );
        Assert.assertEquals( positionBeforeUndoY, positionAfterExcecution + MvcGameConfig.CANNON_MOVE_STEP );
        Assert.assertEquals( positionBeforeUndoX, positionAfterUndoX );
        Assert.assertEquals( positionBeforeUndoY, positionAfterUndoY );
    } 
    
}
