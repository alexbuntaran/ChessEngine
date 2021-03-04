package pieces;

import displayers.ImageLoader;
import utils.Board;
import utils.Constants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Knight extends Piece {

    private BufferedImage sprite;

    public Knight(int color, int num) {
        super(color);
        sprite = ImageLoader.loadImage("Assets.png");
        if (super.color == Color.WHITE) {
            setSquare(Board.getSquare((char) ('B' + num * 5), 1));
            sprite = sprite.getSubimage(600, 0, 200, 200);
        } else {
            setSquare(Board.getSquare((char) ('B' + num * 5), 8));
            sprite = sprite.getSubimage(600, 200, 200, 200);
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
