package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class ChangeDifficultyCmd extends AbstractGameCommand {

    private String difficulty;

    public ChangeDifficultyCmd( IGameModel model, String difficulty ) {
        this.subject = model;
        this.difficulty = difficulty;
    }

    @Override
    protected void execute( ) {
        this.subject.changeDifficulty( difficulty );
    }

}
