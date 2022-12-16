package cz.cvut.fit.miadp.mvcgame.builder;

public class Difficulty {

    private String name;
    private int maxTime;
    private int scoreToReach;
    private int totalMissiles;
    private int numOfEnemies;
    private int numOfObstacles;
    private int numOfBombs;

    public Difficulty( ) { }

    public String getName( ) {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }

    public int getMaxTime( ) {
        return maxTime;
    }
    public void setMaxTime( int maxTime ) {
        this.maxTime = maxTime;
    }

    public int getScoreToReach( ) {
        return scoreToReach;
    }
    public void setScoreToReach( int scoreToReach ) {
        this.scoreToReach = scoreToReach;
    }

    public int getTotalMissiles( ) {
        return totalMissiles;
    }
    public void setTotalMissiles( int totalMissiles ) {
        this.totalMissiles = totalMissiles;
    }

    public int getNumOfEnemies( ) {
        return numOfEnemies;
    }
    public void setNumOfEnemies( int numOfEnemies ) {
        this.numOfEnemies = numOfEnemies;
    }

    public int getNumOfObstacles( ) {
        return numOfObstacles;
    }
    public void setNumOfObstacles( int numOfObstacles ) {
        this.numOfObstacles = numOfObstacles;
    }

    public int getNumOfBombs( ) {
        return numOfBombs;
    }
    public void setNumOfBombs( int numOfBombs ) {
        this.numOfBombs = numOfBombs;
    }

}
