package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class PowerCannonUpCmd extends AbstractGameCommand {

    public PowerCannonUpCmd( IGameModel model ){
        this.subject = model;
    }

    @Override
    protected void execute( ) {
        this.subject.powerCannonUp( );
    }

}
