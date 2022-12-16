package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonRightCmd;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonLeftCmd;
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
                    this.model.aimCannonUp( );
                    break;
                case "DOWN":
                    this.model.aimCannonDown( );
                    break;
                case "LEFT":
                    this.model.registerCommand( new MoveCannonLeftCmd( this.model ) );
                    break;
                case "RIGHT":
                    this.model.registerCommand( new MoveCannonRightCmd( this.model ) );
                    break;
                case "SPACE":
                    this.model.cannonShoot( );
                    break;
                case "R":
                    this.model.restart( );
                    break;
                case "I":
                    this.model.changeDifficulty( MvcGameConfig.EASY_DIFFICULTY );
                    break;
                case "O":
                    this.model.changeDifficulty( MvcGameConfig.NORMAL_DIFFICULTY );
                    break;
                case "P":
                    this.model.changeDifficulty( MvcGameConfig.HARD_DIFFICULTY );
                    break;
                case "E":
                    // tohle do commandu nepredelavat :D
                    this.model.undoLastCommand( );
                    break;
                case "W":
                    this.model.cannonPowerUp( );
                    break;
                case "Q":
                    this.model.cannonPowerDown( );
                    break;
                case "M":
                    this.model.toggleMovingStrategy( );
                    break;
                case "S":
                    this.model.toggleShootingMode();
                    break;
                default: 
                    // nothing
            }
        }
    }

}
