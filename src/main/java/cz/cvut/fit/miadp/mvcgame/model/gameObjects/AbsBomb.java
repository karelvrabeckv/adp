package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsBomb extends LifetimeLimitedGameObject {

    protected AbsBomb( Position position ) {
        super( position );
    }

    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitBomb( this );
    }

}
