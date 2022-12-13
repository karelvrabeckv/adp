package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class GameRenderer implements IVisitor {

    private IGameGraphics gr;

    public void setGraphicContext( IGameGraphics gr ) {
        this.gr = gr;
    }

    @Override
    public void visitCannon( AbsCannon cannon ) {
        this.gr.drawImage( "images/cannon.png", cannon.getPosition( ) );
    }

    @Override
    public void visitMissile( AbsMissile missile ) {
        this.gr.drawImage( "images/missile.png", missile.getPosition( ) );
    }

    @Override
    public void visitEnemy( AbsEnemy enemy ) {
        if ( enemy.getType() == 0 ) {
            this.gr.drawImage( "images/enemy1.png", enemy.getPosition( ) );
        }
        else if ( enemy.getType() == 1 ) {
            this.gr.drawImage( "images/enemy2.png", enemy.getPosition( ) );
        }
    }

}
