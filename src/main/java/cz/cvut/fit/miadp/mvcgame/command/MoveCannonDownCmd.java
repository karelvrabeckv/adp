package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class MoveCannonDownCmd extends AbstractGameCommand {
    
    public MoveCannonDownCmd( IGameModel model ){
        this.subject = model;
    }

    @Override
    protected void execute( ) {
        this.subject.moveCannonDown( );
    }

}
