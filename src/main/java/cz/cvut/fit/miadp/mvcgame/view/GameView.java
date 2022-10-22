package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.Aspect;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements IObserver {

    private GameController controller;
    private GameModel model ;
    private GraphicsContext gr;

    public GameView( GameModel model ){
        this.model = model;
        this.controller = new GameController( model );
        this.gr = null;

        this.model.registerObserver( this, new Aspect( MvcGameConfig.OBSERVABLE_PROP_CHANGE ) );
    }

    public GameController getController( ) {
        return this.controller;
    }

    public void render( ) {
        if( this.gr == null ){
            return;
        }
        gr.clearRect( 0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y );
        this.drawCannon( gr );
    }

    private void drawCannon( GraphicsContext gr ) {
        gr.drawImage(
                new Image( "images/cannon.png" ),
                this.model.getCannonPosition( ).getComponent( MvcGameConfig.DIM_X ),
                this.model.getCannonPosition( ).getComponent( MvcGameConfig.DIM_Y )
        );
    }

    public void setGraphicContext( GraphicsContext gr ) {
        boolean initCall = false;
        if( this.gr == null ) {
            initCall = true;
        }
        this.gr = gr;
        if( initCall ) {
            this.update( null );
        }
    }

    @Override
    public void update( Aspect aspect ) {
        this.render( );
    }

}
