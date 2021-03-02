package pieces;

import displayers.ImageLoader;
import utils.Constants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bishop extends Piece {

    private BufferedImage sprite;

    public Bishop(int color, int num) {
        super(color);
        sprite = ImageLoader.loadImage("Assets.png");
        if (super.color == Color.WHITE) {
            x = Constants.FRAME_WIDTH / 2 - Constants.SQUARE_WIDTH * (Constants.FILES / 2) + Constants.SQUARE_WIDTH * 2 + Constants.SQUARE_WIDTH * 3 * num;
            y = Constants.SQUARE_HEIGHT / 4 + Constants.SQUARE_HEIGHT * 7;
            sprite = sprite.getSubimage(400, 0, 200, 200);
        } else {
            x = Constants.FRAME_WIDTH / 2 - Constants.SQUARE_WIDTH * (Constants.FILES / 2) + Constants.SQUARE_WIDTH * 2 + Constants.SQUARE_WIDTH * 3 * num;
            y = Constants.SQUARE_HEIGHT / 4;
            sprite = sprite.getSubimage(400, 200, 200, 200);
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
