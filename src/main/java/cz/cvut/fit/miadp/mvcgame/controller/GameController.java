package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;

public class GameController {

    private GameModel model;

    public GameController( GameModel model ) {
        this.model = model;
    }

    public void processPressedKeys( List<String> pressedKeysCodes ) {
        for( String code : pressedKeysCodes ) {
            switch( code ) {
                case "UP":
                    this.model.moveCannonUp( );
                    break;
                case "DOWN":
                    this.model.moveCannonDown( );
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
                case "P":
                    this.model.increaseNumOfMissiles();
                    break;
                case "O":
                    this.model.decreaseNumOfMissiles();
                    break;
                case "S":
                    CareTaker.getInstance( ).createMemento( );
                    break;
                case "R":
                    CareTaker.getInstance( ).setMemento( );
                    break;   
                default: 
                    //nothing
            }
        }
    }

}
