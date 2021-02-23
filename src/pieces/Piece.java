package pieces;

public class Piece {

    public enum Color {
        WHITE,
        BLACK
    }

    private Color color;
    
    public Piece(int color) {
        this.color = color == 0 ? Color.WHITE : Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public int getPieceType() {
        return 0;
    }

}
