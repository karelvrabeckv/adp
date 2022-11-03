package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class Missile_A extends AbsMissile {

    public static final int MOVE_STEP = 10;

    public Missile_A( Position initialPosition ){
        this.position = initialPosition;
    }

    public void fly( ) {
        this.move( new Vector( MOVE_STEP, 0 ) );
    }
}
