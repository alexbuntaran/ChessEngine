package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Board {
    
    @SuppressWarnings("unused")
    private int[][] squares;

    public Board() {
        squares = new int[Constants.RANKS][Constants.FILES];
    }

    public void drawBoard(Graphics g) {
        int x = Constants.FRAME_WIDTH / 2 - Constants.SQUARE_WIDTH * (Constants.FILES / 2);
        int y = Constants.SQUARE_HEIGHT / 4;
        char file = 'A';
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(x, y, Constants.FILES * Constants.SQUARE_WIDTH, Constants.RANKS * Constants.SQUARE_HEIGHT);
        g2.drawRect(x - 15, y - 15, Constants.FILES * Constants.SQUARE_WIDTH + 30, Constants.RANKS * Constants.SQUARE_HEIGHT + 30);
        for (int ranks = 0; ranks < Constants.RANKS; ranks++) {
            g.setColor(Color.BLACK);
            g.drawString("" + (Constants.RANKS - ranks), x - 11, y + Constants.SQUARE_HEIGHT / 2);
            g.drawString("" + file, x + (Constants.SQUARE_WIDTH * ranks) + Constants.SQUARE_WIDTH / 2, Constants.SQUARE_HEIGHT / 4 + Constants.SQUARE_HEIGHT * Constants.RANKS + 11);
            file++;
            for (int files = 0; files < Constants.FILES; files++) {
                Color color = (ranks + files) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY;
                g.setColor(color);
                g.fillRect(x, y, Constants.SQUARE_WIDTH, Constants.SQUARE_HEIGHT);
                x += Constants.SQUARE_WIDTH;
            }

            x = Constants.FRAME_WIDTH / 2 - Constants.SQUARE_WIDTH * (Constants.FILES / 2);
            y += Constants.SQUARE_HEIGHT;
        }
    }

}
