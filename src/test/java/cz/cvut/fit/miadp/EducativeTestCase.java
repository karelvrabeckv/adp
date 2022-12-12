package cz.cvut.fit.miadp;

import org.junit.Assert;
import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonUpCmd;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class EducativeTestCase {

    @Test
    public void undoCommandTest( ){
        IGameModel model = new GameModel( );
        int positionBeforeUndoX = model.getCannonPosition( ).getX( );
        int positionBeforeUndoY = model.getCannonPosition( ).getY( );
        model.registerCommand( new MoveCannonUpCmd( model ) );
        model.update( );
        int positionAfterExcecution = model.getCannonPosition( ).getY( );
        model.undoLastCommand( );
        int positionAfterUndoX = model.getCannonPosition( ).getX( );
        int positionAfterUndoY = model.getCannonPosition( ).getY( );
        Assert.assertEquals( positionBeforeUndoY, positionAfterExcecution + MvcGameConfig.MOVE_STEP );
        Assert.assertEquals( positionBeforeUndoX, positionAfterUndoX );
        Assert.assertEquals( positionBeforeUndoY, positionAfterUndoY );
    } 
    
}
