package cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsGameInfo;

import java.time.LocalDateTime;

public class GameInfo_A extends AbsGameInfo {

    public GameInfo_A( Position position, IGameModel model ) {
        this.position = position;
        this.model = model;
        this.start = LocalDateTime.now( );
        this.score = 0;
        this.usedMissiles = 0;
        this.movingStrategy = AbsGameInfo.SIMPLE_MOVING_STRATEGY;
    }

    public GameInfo_A( GameInfo_A gameInfo ) {
        position = gameInfo.position;
        model = gameInfo.model;
        start = gameInfo.start;
        score = gameInfo.score;
        usedMissiles = gameInfo.usedMissiles;
        movingStrategy = gameInfo.movingStrategy;
    }

    @Override
    public Position offsetPosition( int multiplier ) {
        Position position = new Position( this.position.getX( ), this.position.getY( ) );
        position.add( new Vector( 0, multiplier * MvcGameConfig.GAME_INFO_OFFSET ) );

        return position;
    }

    @Override
    public AbsGameInfo clone( ) {
        return new GameInfo_A( this );
    }

}
