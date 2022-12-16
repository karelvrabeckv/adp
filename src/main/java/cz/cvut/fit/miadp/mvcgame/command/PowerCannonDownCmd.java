package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class PowerCannonDownCmd extends AbstractGameCommand {

    public PowerCannonDownCmd( IGameModel model ){
        this.subject = model;
    }

    @Override
    protected void execute( ) {
        this.subject.powerCannonDown( );
    }

}
