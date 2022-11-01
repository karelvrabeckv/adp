package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsMissile extends GameObject {

    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitMissile( this ); 
        
    }
    
}
