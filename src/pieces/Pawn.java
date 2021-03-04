package pieces;

import displayers.ImageLoader;
import utils.Board;
import utils.Constants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Pawn extends Piece {

    private BufferedImage sprite;

    public Pawn(int color, int num) {
        super(color);
        sprite = ImageLoader.loadImage("Assets.png");
        if (super.color == Color.WHITE) {
            setSquare(Board.getSquare((char) ('A' + num), 2));
            sprite = sprite.getSubimage(1000, 0, 200, 200);
        } else {
            setSquare(Board.getSquare((char) ('A' + num), 7));
            sprite = sprite.getSubimage(1000, 200, 200, 200);
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
