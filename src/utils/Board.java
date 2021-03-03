package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Board {
    
    private static Square[][] squares;

    public Board() {
        squares = new Square[Constants.FILES][Constants.RANKS];
        int x = Constants.FRAME_WIDTH / 2 - Constants.SQUARE_WIDTH * (Constants.FILES / 2);
        int y = Constants.SQUARE_HEIGHT / 4 + Constants.SQUARE_HEIGHT * 7;
        for (int files = 0; files < Constants.FILES; files++) {
            for (int ranks = 0; ranks < Constants.RANKS; ranks++) {
                squares[files][ranks] = new Square(x, y);
                y -= Constants.SQUARE_HEIGHT;
            }

            y = Constants.SQUARE_HEIGHT / 4 + Constants.SQUARE_HEIGHT * 7;
            x += Constants.SQUARE_WIDTH;
        }
    }

    public void drawBoard(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(squares[0][7].getX(), squares[0][7].getY(), Constants.FILES * Constants.SQUARE_WIDTH, Constants.RANKS * Constants.SQUARE_HEIGHT);
        g2.drawRect(squares[0][7].getX() - 15, squares[0][7].getY() - 15, Constants.FILES * Constants.SQUARE_WIDTH + 30, Constants.RANKS * Constants.SQUARE_HEIGHT + 30);
        char file = 'A';
        for (int files = 0; files < Constants.FILES; files++) {
            g.setColor(Color.BLACK);
            g.drawString("" + file, squares[files][0].getX() + Constants.SQUARE_WIDTH / 2, squares[0][0].getY() + Constants.SQUARE_HEIGHT + 11);
            g.drawString("" + (files + 1), squares[0][0].getX() - 11, squares[0][files].getY() + Constants.SQUARE_HEIGHT - Constants.SQUARE_HEIGHT / 2);
            file++;
            for (int ranks = 0; ranks < Constants.RANKS; ranks++) {
                Color color = (files + ranks) % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY;
                g.setColor(color);
                g.fillRect(squares[files][ranks].getX(), squares[files][ranks].getY(), Constants.SQUARE_WIDTH, Constants.SQUARE_HEIGHT);
            }
        }
    }

    public static Square getSquare(char file, int rank) {
        return squares[(int) file - 65][rank - 1];
    }

}
