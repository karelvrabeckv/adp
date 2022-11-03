package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class GameAudio implements IVisitor {

    @Override
    public void visitCannon( AbsCannon cannon ) {
        this.playSound( "sounds/cannon.mp3" );
    }

    @Override
    public void visitMissile( AbsMissile missile ) {
        this.playSound( "sounds/missile.mp3" );
    }

    public void playSound( String path ) {
        Runnable r = new GameAudioRunnable( path );
        Thread t = new Thread( r );
        t.start();
    }

}
