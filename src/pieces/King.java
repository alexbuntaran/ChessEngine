package pieces;

import java.awt.Graphics;

public class King extends Piece {

    private int x;
    private int y;
    
    public King(int color) {
        super(color);
        x = 10;
        y = 10;
    }

    public void update() {
        
    }

    public void render(Graphics g) {
        g.fillRect(x, y, 100, 100);
    }

}
