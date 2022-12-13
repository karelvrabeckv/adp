package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig {
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;
    public static final int MOVE_STEP = 10;
    public static final int CANNON_POS_X = 50;
    public static final int CANNON_POS_Y = MAX_Y / 2;
    public static final int INIT_POWER = 10;
    public static final double INIT_ANGLE = 0;
    public static final double ANGLE_STEP = Math.PI / 18;
    public static final int POWER_STEP = 1;
    public static final double GRAVITY = 9.8;

    // enemies
    public static final int NUM_OF_ENEMIES = 10;
    public static final int NUM_OF_ENEMY_TYPES = 2;

    // bounds for enemies
    public static final int MIN_X_BOUND = CANNON_POS_X + 100;
    public static final int MAX_X_BOUND = MAX_X - 50;
    public static final int MIN_Y_BOUND = 50;
    public static final int MAX_Y_BOUND = MAX_Y - 50;
}
