package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitable;

public abstract class GameObject implements IVisitable {

    protected Position position;
    
    public void move( Vector vector ){
        this.position.add( vector );
    }

    public double getDistanceTo( GameObject object ) {
        int x_diff = object.getPosition().getX() - this.position.getX();
        int y_diff = object.getPosition().getY() - this.position.getY();

        return Math.sqrt(Math.pow(x_diff, 2) + Math.pow(y_diff, 2));
    }

    public Position getPosition( ) {
        return this.position;
    }
    
}
