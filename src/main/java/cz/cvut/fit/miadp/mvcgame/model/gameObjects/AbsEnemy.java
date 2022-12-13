package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsEnemy extends LifetimeLimitedGameObject {

    private int type;

    protected AbsEnemy( Position position, int type ) {
        super( position );
        this.type = type;
    }

    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitEnemy( this );
    }

    public int getType() {
        return type;
    }

}
