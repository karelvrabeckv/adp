package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;

public class Cannon extends GameObject {

    public Cannon( Vector initialPosition ){
        this.position = initialPosition;
    }

    public void moveUp( ) {
        this.move( new Vector( 0, -1 * MvcGameConfig.MOVE_STEP ) );
    }

    public void moveDown( ) {
        this.move( new Vector( 0, MvcGameConfig.MOVE_STEP ) );
    }

}
