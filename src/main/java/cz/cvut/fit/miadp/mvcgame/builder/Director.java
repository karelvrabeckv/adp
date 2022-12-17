package cz.cvut.fit.miadp.mvcgame.builder;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

public class Director {

    private Builder builder;

    public void setBuilder( Builder builder ) {
        this.builder = builder;
    }

    public void constructEasyDifficulty( Builder builder ) {
        builder.reset( Difficulty.getInstance( Difficulty.Key.EASY ) );
        builder.setName( MvcGameConfig.EASY_DIFFICULTY );
        builder.setMaxTime( 300 );
        builder.setScoreToReach( 50 );
        builder.setTotalMissiles( 200 );
        builder.setNumOfEnemies( 20 );
        builder.setNumOfObstacles( 3 );
        builder.setNumOfBombs( 5 );
    }

    public void constructNormalDifficulty( Builder builder ) {
        builder.reset( Difficulty.getInstance( Difficulty.Key.MEDIUM ) );
        builder.setName( MvcGameConfig.MEDIUM_DIFFICULTY );
        builder.setMaxTime( 180 );
        builder.setScoreToReach( 40 );
        builder.setTotalMissiles( 100 );
        builder.setNumOfEnemies( 10 );
        builder.setNumOfObstacles( 10 );
        builder.setNumOfBombs( 3 );
    }

    public void constructHardDifficulty( Builder builder ) {
        builder.reset( Difficulty.getInstance( Difficulty.Key.HARD ) );
        builder.setName( MvcGameConfig.HARD_DIFFICULTY );
        builder.setMaxTime( 60 );
        builder.setScoreToReach( 30 );
        builder.setTotalMissiles( 50 );
        builder.setNumOfEnemies( 5 );
        builder.setNumOfObstacles( 15 );
        builder.setNumOfBombs( 1 );
    }

}
