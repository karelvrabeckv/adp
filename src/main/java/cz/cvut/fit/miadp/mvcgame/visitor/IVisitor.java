package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

public interface IVisitor {

    public void visitCannon( AbsCannon cannon );
    public void visitMissile( AbsMissile missile );
    public void visitEnemy( AbsEnemy enemy );
    public void visitCollision( AbsCollision collision );
    public void visitGameInfo( AbsGameInfo gameInfo );

}
