package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsObstacle extends LifetimeLimitedGameObject {

    protected AbsObstacle( Position position ) {
        super( position );
    }

    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitObstacle( this );
    }

}
