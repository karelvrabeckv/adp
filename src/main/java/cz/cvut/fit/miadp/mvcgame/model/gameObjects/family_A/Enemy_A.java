package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;

public class Enemy_A extends AbsEnemy {

    private IGameObjectFactory factory;

    public Enemy_A( Position position, int type, IGameObjectFactory factory ) {
        super( position, type );
        this.factory = factory;
    }

    public Enemy_A( Enemy_A enemy ) {
        super( enemy.position.clone( ), enemy.type );
        factory = enemy.factory;
    }

    @Override
    public AbsCollision explode( ) {
        return this.factory.createCollision( this.position );
    }

    @Override
    public AbsEnemy clone( ) {
        return new Enemy_A( this );
    }

}
