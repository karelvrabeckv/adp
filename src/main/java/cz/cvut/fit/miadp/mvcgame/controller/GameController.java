package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.*;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class GameController {

    private IGameModel model;

    public GameController( IGameModel model ) {
        this.model = model;
    }

    public void processPressedKeys( List<String> pressedKeysCodes ) {
        for( String code : pressedKeysCodes ) {
            switch( code ) {
                case "UP":
                    this.model.registerCommand( new AimCannonUpCmd( this.model ) );
                    break;
                case "DOWN":
                    this.model.registerCommand( new AimCannonDownCmd( this.model ) );
                    break;
                case "LEFT":
                    this.model.registerCommand( new MoveCannonLeftCmd( this.model ) );
                    break;
                case "RIGHT":
                    this.model.registerCommand( new MoveCannonRightCmd( this.model ) );
                    break;
                case "SPACE":
                    this.model.registerCommand( new CannonShootCmd( this.model ) );
                    break;
                case "R":
                    this.model.registerCommand( new RestartCmd( this.model ) );
                    break;
                case "I":
                    this.model.registerCommand( new ChangeDifficultyCmd( this.model, MvcGameConfig.EASY_DIFFICULTY ) );
                    break;
                case "O":
                    this.model.registerCommand( new ChangeDifficultyCmd( this.model, MvcGameConfig.NORMAL_DIFFICULTY ) );
                    break;
                case "P":
                    this.model.registerCommand( new ChangeDifficultyCmd( this.model, MvcGameConfig.HARD_DIFFICULTY ) );
                    break;
                case "W":
                    this.model.registerCommand( new PowerCannonUpCmd( this.model ) );
                    break;
                case "Q":
                    this.model.registerCommand( new PowerCannonDownCmd( this.model ) );
                    break;
                case "M":
                    this.model.registerCommand( new ToggleMovingStrategyCmd( this.model ) );
                    break;
                case "S":
                    this.model.registerCommand( new ToggleShootingModeCmd( this.model ) );
                    break;
                case "E":
                    this.model.undoLastCommand( );
                    break;
                default: 
                    // nothing
            }
        }
    }

}
