package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class MoveCannonRightCmd extends AbstractGameCommand {
    
    public MoveCannonRightCmd( IGameModel model ){
        this.subject = model;
    }

    @Override
    protected void execute( ) {
        this.subject.moveCannonRight( );
    }

}
