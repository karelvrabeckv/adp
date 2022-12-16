package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class ToggleShootingModeCmd extends AbstractGameCommand {

    public ToggleShootingModeCmd( IGameModel model ){
        this.subject = model;
    }

    @Override
    protected void execute( ) {
        this.subject.toggleShootingMode( );
    }

}
