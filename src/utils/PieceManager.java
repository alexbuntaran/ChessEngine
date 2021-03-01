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
            pieces[i][2] = new Rook(i);
            pieces[i][3] = new Rook(i);
            pieces[i][4] = new Bishop(i);
            pieces[i][5] = new Bishop(i);
            pieces[i][6] = new Knight(i);
            pieces[i][7] = new Knight(i);
            pieces[i][8] = new Pawn(i);
            pieces[i][9] = new Pawn(i);
            pieces[i][10] = new Pawn(i);
            pieces[i][11] = new Pawn(i);
            pieces[i][12] = new Pawn(i);
            pieces[i][13] = new Pawn(i);
            pieces[i][14] = new Pawn(i);
            pieces[i][15] = new Pawn(i);
        }
    }

    public void update() {
        // determine which piece is selected
        // determine where the piece should move

        if (selected) {
            pieces[pieceX][pieceY].update(mouseX, mouseY, Turn.MOVE);
        }
    }

    public void render(Graphics g) {
        g.drawString(mouseX + ", " + mouseY, 10, 10);
        g.drawString("" + selected, 10, 30);
        // draw the pieces
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
        selected = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
