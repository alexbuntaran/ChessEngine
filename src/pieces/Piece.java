package pieces;

import java.awt.Graphics;

public abstract class Piece {

    public enum Color {
        WHITE,
        BLACK
    }

    public enum Turn {
        MOVE,
        CAPTURE
    }

    protected Color color;
    protected int x;
    protected int y;
    protected Turn turn;
    
    public Piece(int color) {
        this.color = color == 0 ? Color.WHITE : Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public int getPieceType() {
        return 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void update(int x, int y, Turn turn);

    public abstract void render(Graphics g);

}
