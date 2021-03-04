package pieces;

import java.awt.Graphics;

import utils.Square;

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
    protected Square square;
    protected boolean captured;
    
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

    public void remove() {
        captured = true;
        x = 0;
        y = 0;
    }

    public void setSquare(Square square) {
        this.square = square;
        x = square.getX();
        y = square.getY();
        square.setPiece(this);
    }

    public Square getSquare() {
        return square;
    }

    public abstract void update(int x, int y, Turn turn);

    public abstract void render(Graphics g);

}
