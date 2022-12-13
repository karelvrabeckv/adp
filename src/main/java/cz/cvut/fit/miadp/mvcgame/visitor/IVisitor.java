package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;

public interface IVisitor {

    public void visitCannon( AbsCannon cannon );
    public void visitMissile( AbsMissile missile );
    public void visitEnemy( AbsEnemy enemy );
    public void visitCollision( AbsCollision collision );

    // TODO visitGameInfo( ... );

}
