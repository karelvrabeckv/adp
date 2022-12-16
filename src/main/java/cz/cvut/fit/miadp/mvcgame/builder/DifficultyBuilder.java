package cz.cvut.fit.miadp.mvcgame.builder;

public class DifficultyBuilder implements Builder {

    private Difficulty difficulty;

    public DifficultyBuilder( ) {
        reset( );
    }

    @Override
    public void reset( ) {
        difficulty = new Difficulty( );
    }

    @Override
    public void setName( String name ) {
        difficulty.setName( name );
    }

    @Override
    public void setMaxTime( int maxTime ) {
        difficulty.setMaxTime( maxTime );
    }

    @Override
    public void setScoreToReach( int scoreToReach ) {
        difficulty.setScoreToReach( scoreToReach );
    }

    @Override
    public void setTotalMissiles( int totalMissiles ) {
        difficulty.setTotalMissiles( totalMissiles );
    }

    @Override
    public void setNumOfEnemies( int numOfEnemies ) {
        difficulty.setNumOfEnemies( numOfEnemies );
    }

    @Override
    public void setNumOfObstacles( int numOfObstacles ) {
        difficulty.setNumOfObstacles( numOfObstacles );
    }

    @Override
    public void setNumOfBombs( int numOfBombs ) {
        difficulty.setNumOfBombs( numOfBombs );
    }

    public Difficulty getProduct( ) {
        Difficulty difficulty = this.difficulty;
        reset( );

        return difficulty;
    }

}
