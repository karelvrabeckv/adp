package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Vector;

public abstract class GameObject {

    protected Vector position;
    
    public void move( Vector vector ){
        this.position.add( vector );
    }

    public Vector getPosition( ) {
        return this.position;
    }
    
}
