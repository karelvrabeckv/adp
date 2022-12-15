package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig {
    // screen
    public static final int SCREEN_X = 1280;
    public static final int SCREEN_Y = 720;

    // cannon
    public static final int CANNON_X = SCREEN_X / 2;
    public static final int CANNON_Y = 555;
    public static final int CANNON_MOVE_STEP = 10;
    public static final int CANNON_INIT_POWER = 10;
    public static final int CANNON_POWER_STEP = 1;
    public static final double CANNON_INIT_ANGLE = 0;
    public static final double CANNON_ANGLE_STEP = Math.PI / 36;
    public static final double CANNON_L_BOUND = 150;
    public static final double CANNON_R_BOUND = SCREEN_X - 150;

    // missiles
    public static final double GRAVITY = 9.8;

    // collisions
    public static final int COLLISION_DISTANCE = 25;
    public static final int COLLISION_AGE = 3000;

    // enemies
    public static final int NUM_OF_ENEMIES = 10;
    public static final int NUM_OF_ENEMY_TYPES = 2;

    // bounds for enemies
    public static final int MIN_X_BOUND = 150;
    public static final int MAX_X_BOUND = SCREEN_X - 150;
    public static final int MIN_Y_BOUND = 50;
    public static final int MAX_Y_BOUND = CANNON_Y - 100;

    // game info
    public static final int GAME_INFO_POS_X = 10;
    public static final int GAME_INFO_POS_Y = 20;
    public static final int GAME_INFO_OFFSET = 20;

    // obstacles
    public static final int NUM_OF_OBSTACLES = 5;

    // bombs
    public static final int NUM_OF_BOMBS = 3;
    public static final int BOMB_DISTANCE = 150;
}
