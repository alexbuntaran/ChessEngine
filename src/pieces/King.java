package pieces;

import displayers.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class King extends Piece {

    private BufferedImage sprite;
    
    public King(int color) {
        super(color);
        x = 115;
        y = 115;
        sprite = ImageLoader.loadImage("Assets.png");
        sprite = sprite.getSubimage(0, 0, 200, 200);
    }

    @Override
    public void update(int x, int y, Turn turn) {
        this.x = x - 50; // subtract by width / 2
        this.y = y - 50; // subtract by height / 2
        this.turn = turn;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, x, y, 100, 100, null);
    }

}
