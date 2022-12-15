package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class MoveCannonLeftCmd extends AbstractGameCommand {

    public MoveCannonLeftCmd( IGameModel model ){
        this.subject = model;
    }

    @Override
    protected void execute( ) {
        this.subject.moveCannonLeft( );
    }
    
}
