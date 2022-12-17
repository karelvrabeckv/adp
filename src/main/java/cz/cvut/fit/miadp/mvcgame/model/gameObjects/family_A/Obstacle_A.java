package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsObstacle;

public class Obstacle_A extends AbsObstacle {

    public Obstacle_A( Position position ) {
        super( position );
    }

    public Obstacle_A( Obstacle_A obstacle ) {
        super( obstacle.position.clone( ) );
    }

    @Override
    public AbsObstacle clone( ) {
        return new Obstacle_A( this );
    }

}
