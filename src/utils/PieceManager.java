package utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class PieceManager implements MouseListener {

    private Piece[][] pieces;

    public PieceManager() {
        pieces = new Piece[Constants.PLAYERS][Constants.PIECES];
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

    }

    public void render(Graphics g) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}
