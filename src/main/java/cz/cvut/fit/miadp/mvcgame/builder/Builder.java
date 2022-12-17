package cz.cvut.fit.miadp.mvcgame.builder;

public interface Builder {

    public void reset( Difficulty difficulty );
    public void setName( String name );
    public void setMaxTime( int maxTime );
    public void setScoreToReach( int scoreToReach );
    public void setTotalMissiles( int totalMissiles );
    public void setNumOfEnemies( int numOfEnemies );
    public void setNumOfObstacles( int numOfObstacles );
    public void setNumOfBombs( int numOfBombs );

}
