package utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import pieces.Piece.Turn;

public class PieceManager implements MouseMotionListener, MouseListener {

    private Piece[][] pieces;
    private int pieceX;
    private int pieceY;
    private int mouseX;
    private int mouseY;
    private boolean selected;

    public PieceManager() {
        pieces = new Piece[Constants.PLAYERS][Constants.PIECES];
        pieceX = 0;
        pieceY = 0;
        mouseX = 0;
        mouseY = 0;
        selected = false;
    }

    public void addPieces() {
        for (int i = 0; i < 2; i++) {
            pieces[i][0] = new King(i);
            pieces[i][1] = new Queen(i);

            int count = 2;
            for (int j = 0; j < 2; j++) {
                pieces[i][count++] = new Rook(i, j);
            }

            for (int j = 0; j < 2; j++) {
                pieces[i][count++] = new Bishop(i, j);
            }

            for (int j = 0; j < 2; j++) {
                pieces[i][count++] = new Knight(i, j);
            }

            for (int j = 0; j < 8; j++) {
                pieces[i][count++] = new Pawn(i, j);
            }
        }
    }

    public void update() {
        if (selected) {
            pieces[pieceX][pieceY].update(mouseX, mouseY, Turn.MOVE);
        }
    }

    public void render(Graphics g) {
        g.drawString(mouseX + ", " + mouseY, 10, 10);
        g.drawString("" + selected, 10, 30);
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                pieces[i][j].render(g);
            }
        }

        pieces[pieceX][pieceY].render(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                if ((mouseX >= pieces[i][j].getX() && mouseX <= pieces[i][j].getX() + 100) && (mouseY >= pieces[i][j].getY() && mouseY <= pieces[i][j].getY() + 100)) {
                    pieceX = i;
                    pieceY = j;
                    selected = true;
                    break;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO: create actual move methods that can be used to move the certain squares
        selected = false;
        Square desiredSquare = pieces[pieceX][pieceY].getSquare();
        for (char files = 'A'; files <= 'H'; files++) {
            for (int ranks = 1; ranks <= Constants.RANKS; ranks++) {
                Square square = Board.getSquare(files, ranks);
                if (e.getX() >= square.getX() && e.getX() <= square.getX() + Constants.SQUARE_WIDTH && e.getY() >= square.getY() && e.getY() <= square.getY() + Constants.SQUARE_HEIGHT) {
                    desiredSquare.removePiece();
                    desiredSquare = square;
                    break;
                }
            }
        }

        if (desiredSquare.getPiece() != null) {
            desiredSquare.removePiece();
        }

        pieces[pieceX][pieceY].setSquare(desiredSquare);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
