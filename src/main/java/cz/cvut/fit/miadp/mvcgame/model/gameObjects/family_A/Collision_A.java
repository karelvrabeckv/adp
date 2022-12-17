package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;

public class Collision_A extends AbsCollision {

    public Collision_A( Position position ) {
        super( position );
    }

    public Collision_A( Collision_A collision ) {
        super( collision.position.clone( ) );
    }

    @Override
    public AbsCollision clone( ) {
        return new Collision_A( this );
    }

}
