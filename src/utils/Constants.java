package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {

    public static final String NAME = "Simple Chess Engine";
    public static final Dimension FRAME_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int FRAME_WIDTH = (int) FRAME_SIZE.getWidth();
    public static final int FRAME_HEIGHT = (int) FRAME_SIZE.getHeight();
    public static final int NUMBER_OF_BUFFERS = 3;
    public static final int FILES = 8;
    public static final int RANKS = 8;
    public static final int PLAYERS = 2;
    public static final int PIECES = 16;
    public static final int SQUARE_WIDTH = 100;
    public static final int SQUARE_HEIGHT = 100;
    
}
