package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsBomb;

public class Bomb_A extends AbsBomb {

    private IGameObjectFactory factory;

    public Bomb_A( Position position, IGameObjectFactory factory ) {
        super( position );
        this.factory = factory;
    }

}
