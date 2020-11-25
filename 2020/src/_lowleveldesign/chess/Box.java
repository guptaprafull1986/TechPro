package _lowleveldesign.chess;

import _lowleveldesign.chess.component.Piece;

public class Box {
    private int row;
    private int col;
    private Piece piece;

    public Box(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
