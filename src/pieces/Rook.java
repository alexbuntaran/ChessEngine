package pieces;

import displayers.ImageLoader;
import utils.Board;
import utils.Constants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Rook extends Piece {

    private BufferedImage sprite;

    public Rook(int color, int num) {
        super(color);
        sprite = ImageLoader.loadImage("Assets.png");
        if (super.color == Color.WHITE) {
            x = Board.getSquare((char) ('A' + num * 7), 1).getX();
            y = Board.getSquare((char) ('A' + num * 7), 1).getY();
            sprite = sprite.getSubimage(800, 0, 200, 200);
        } else {
            x = Board.getSquare((char) ('A' + num * 7), 8).getX();
            y = Board.getSquare((char) ('A' + num * 7), 8).getY();
            sprite = sprite.getSubimage(800, 200, 200, 200);
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
