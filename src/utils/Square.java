package utils;

import java.awt.Color;
import java.awt.Graphics;

import pieces.Piece;

public class Square {

    private int x;
    private int y;
    private Color color;
    private Piece piece;

    public Square(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        piece.remove();
        piece = null;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, Constants.SQUARE_WIDTH, Constants.SQUARE_HEIGHT);
    }
    
}
