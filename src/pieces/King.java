package pieces;

import displayers.ImageLoader;
import utils.Board;
import utils.Constants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class King extends Piece {

    private BufferedImage sprite;

    public King(int color) {
        super(color);
        sprite = ImageLoader.loadImage("Assets.png");
        if (super.color == Color.WHITE) {
            x = Board.getSquare('E', 1).getX();
            y = Board.getSquare('E', 1).getY();
            sprite = sprite.getSubimage(0, 0, 200, 200);
        } else {
            x = Board.getSquare('E', 8).getX();
            y = Board.getSquare('E', 8).getY();
            sprite = sprite.getSubimage(0, 200, 200, 200);
        }        
    }

    @Override
    public void update(int x, int y, Turn turn) {
        this.x = x - Constants.SQUARE_WIDTH / 2;
        this.y = y - Constants.SQUARE_HEIGHT / 2;
        this.turn = turn;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, x, y, 100, 100, null);
    }

}
