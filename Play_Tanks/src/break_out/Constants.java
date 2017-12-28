package break_out;

import java.awt.Color;

/**
 * A class that contains all constant values to configure the game
 * 
 * @author dmlux, modified by I. Schumacher
 * 
 */
public class Constants {

    /**
     * The screen width in pixels
     */
    public static final double SCREEN_WIDTH = 800;
    
    /**
     * The screen height in pixels
     */
    public static final double SCREEN_HEIGHT = 600;
    
    /**
     * the application name
     */
    public static final String APP_TITLE = "iBreakOut";

    /**
     * Debugging flag for special rendering hints
     */
    public static final boolean DEBUG_MODE = false;

    /**
     * The background color for the game menu
     */
    public static final Color BACKGROUND = new Color(52, 152, 219);

    /**
     * Amount of columns for blocks
     */
    public static final int SQUARES_X = 20;

    /**
     * Amount of the rows
     */
    public static final int SQUARES_Y = 24;
    
    /**
     * The paddle width in pixels
     */
    public static final double SHIP_WIDTH = 40;  //70
    
    /**
     * The paddle height in pixels
     */
    public static final double SHIP_HEIGHT = 15;
<<<<<<< HEAD
=======
    
    /**
     * The ball diameter in pixels
     */
    public static final double BALL_DIAMETER = 15;
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
       
    /**
     * The paddle speed
     */
    public static final double DX_MOVEMENT = 4.5;
    
    /**
<<<<<<< HEAD
     * The gravity constant, that affects the missle
     */
    public static final double GRAVITY = 9;
    
    public static final double MISSLE_SPEED = 1;
=======
     * The ball speed
     */
    public static final double BALL_SPEED = 1.20;
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
    
}
