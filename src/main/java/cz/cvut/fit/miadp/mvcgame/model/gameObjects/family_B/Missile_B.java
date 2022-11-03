package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_B;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class Missile_B extends AbsMissile {

    public static final int MOVE_STEP = 20;

    public Missile_B( Position initialPosition ){
        this.position = initialPosition;
    }

    public void fly( ) {
        this.move( new Vector( MOVE_STEP, 0 ) );
    }
}
