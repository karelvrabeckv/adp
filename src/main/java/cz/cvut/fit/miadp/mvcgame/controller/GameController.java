package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonDownCmd;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonUpCmd;
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
                    this.model.registerCommand( new MoveCannonUpCmd( this.model ) );
                    break;
                case "DOWN":
                    this.model.registerCommand( new MoveCannonDownCmd( this.model ) );
                    break;
                case "SPACE":
                    this.model.cannonShoot( );
                    break;
                case "A":
                    this.model.aimCannonUp( );
                    break;
                case "Y":
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
                    this.model.undoLastCommand( );
                    break;
                 
                default: 
                    //nothing
            }
        }
    }

}
