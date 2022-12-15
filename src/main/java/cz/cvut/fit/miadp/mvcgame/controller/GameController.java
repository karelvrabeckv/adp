package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonRightCmd;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonLeftCmd;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class GameController {

    private IGameModel model;

    public GameController( IGameModel model ) {
        this.model = model;
    }

    public void processPressedKeys( List<String> pressedKeysCodes ) {
        for( String code : pressedKeysCodes ) {
            switch( code ) {
                case "LEFT":
                    this.model.registerCommand( new MoveCannonLeftCmd( this.model ) );
                    break;
                case "RIGHT":
                    this.model.registerCommand( new MoveCannonRightCmd( this.model ) );
                    break;
                case "SPACE":
                    this.model.cannonShoot( );
                    break;
                case "UP":
                    this.model.aimCannonUp( );
                    break;
                case "DOWN":
                    this.model.aimCannonDown( );
                    break;
                case "F":
                    this.model.cannonPowerUp( );
                    break;
                case "D":
                    this.model.cannonPowerDown( );
                    break;
                case "M":
                    this.model.toggleMovingStrategy( );
                    break;
                case "N":
                    this.model.toggleShootingMode();
                    break;
                case "B":
                    // tohle do commandu nepredelavat :D
                    this.model.undoLastCommand( );
                    break;
                 
                default: 
                    //nothing
            }
        }
    }

}
