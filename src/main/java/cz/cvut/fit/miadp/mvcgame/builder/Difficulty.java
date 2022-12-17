package cz.cvut.fit.miadp.mvcgame.builder;

import java.util.HashMap;
import java.util.Map;

public class Difficulty {

    public enum Key { EASY, MEDIUM, HARD }

    private final Key key;

    private static Map<Key, Difficulty> DIFFICULTIES = new HashMap<>( );

    static {
        for ( Key key : Key.values( ) ) {
            DIFFICULTIES.put( key, new Difficulty( key ) );
        }
    }

    private Difficulty( Key key ) {
        this.key = key;
    }

    public static Difficulty getInstance( Key key ) {
        return DIFFICULTIES.get( key );
    }

    private String name;
    private int maxTime;
    private int scoreToReach;
    private int totalMissiles;
    private int numOfEnemies;
    private int numOfObstacles;
    private int numOfBombs;

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
