package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class JavaFxGraphics implements IGameGraphicsImplementor {

    private GraphicsContext gr;

    public JavaFxGraphics( GraphicsContext gr ) {
        this.gr = gr;
    }

    @Override
    public void drawImage(String path, Position pos) {
        Image image = new Image( path );
        this.gr.drawImage( image, pos.getX( ), pos.getY( ) );
    }

    @Override
    public void drawText(String text, Position pos) {
        this.gr.fillText(text, pos.getX( ),  pos.getY( ) );
    }

    @Override
    public void drawLine(Position beginPosition, Position endPosition) {
        this.gr.strokeLine( beginPosition.getX( ),  beginPosition.getY( ), endPosition.getX( ),  endPosition.getY( ));
    }

    @Override
    public void clear( ) {
        this.gr.clearRect( 0, 0, MvcGameConfig.SCREEN_X,  MvcGameConfig.SCREEN_Y );
    }
    
}
