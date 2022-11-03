package cz.cvut.fit.miadp.mvcgame.visitor;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class GameAudioRunnable implements Runnable {

    private String path;

    public GameAudioRunnable( String path ) {
        this.path = path;
    }

    public void run() {
        try {
            InputStream stream = getClass( ).getClassLoader( ).getResourceAsStream( this.path );
            BufferedInputStream buffer = new BufferedInputStream( stream );
            Player player = new Player( buffer );
            player.play( );
        } catch ( Exception e ) {
            System.out.println( e );
        }
    }

}
