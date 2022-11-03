package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class Cannon_A extends AbsCannon {

    private IGameObjectFactory goFact;
    public static final int MOVE_STEP = 5;

    public Cannon_A( Position initialPosition, IGameObjectFactory goFact ){
        this.position = initialPosition;
        this.goFact = goFact;
    }

    public void moveUp( ) {
        this.move( new Vector( 0, -1 * MOVE_STEP ) );
    }

    public void moveDown( ) {
        this.move( new Vector( 0, MOVE_STEP ) );
    }

    @Override
    public AbsMissile shoot( ) {
        return this.goFact.createMissile( new Position( this.getPosition( ).getX( ), this.getPosition( ).getY( ) ) );
    }

}