package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsBomb;

public class Bomb_A extends AbsBomb {

    public Bomb_A( Position position ) {
        super( position );
    }

    public Bomb_A( Bomb_A bomb ) {
        super( bomb.position.clone( ) );
    }

    @Override
    public AbsBomb clone( ) {
        return new Bomb_A( this );
    }

}
