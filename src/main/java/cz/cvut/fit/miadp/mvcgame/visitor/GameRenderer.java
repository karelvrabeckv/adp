package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameRenderer implements IVisitor {

    private GraphicsContext gr;

    public void setGraphicContext( GraphicsContext gr ) {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        this.gr.drawImage( new Image( "images/cannon.png" ), cannon.getPosition( ).getX( ), cannon.getPosition( ).getY( ) );
        
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        this.gr.drawImage( new Image( "images/missile.png" ), missile.getPosition().getX( ), missile.getPosition().getY( ) );
        
    }
    
}
