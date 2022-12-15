package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameRenderer;

public class GameView implements IObserver {

    private GameController controller;
    private IGameModel model ;
    private IGameGraphics gr;
    private GameRenderer renderer;

    public GameView( IGameModel model ) {
        this.model = model;
        this.controller = new GameController( model );
        this.gr = null;
        this.model.registerObserver( this );
        this.renderer = new GameRenderer( );
    }

    public GameController getController( ) {
        return this.controller;
    }

    public void render( ) {
        this.gr.clear( );

        for ( GameObject gameObject : this.model.getGameObjects( ) ) {
            gameObject.acceptVisitor( this.renderer );
        }
    }

    public void setGraphicContext( IGameGraphics gr ) {
        this.gr = gr;
        this.renderer.setGraphicContext( gr );
        this.update( );
    }

    @Override
    public void update( ) {
        this.render( );
    }

}
