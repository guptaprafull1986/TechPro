package _lowleveldesign.chess.constant;

import _lowleveldesign.chess.Box;
import _lowleveldesign.chess.component.*;

public class Board {
    private Box[][] boxes;

    public Board() {
        resetBoard();
    }

    public Box getBox(int row, int col) throws Exception {
        if(row < 0 || row > 7 || col < 0 || col > 7) {
            throw new Exception("Index out of bound");
        }
        return boxes[row][col];
    }
    public void resetBoard() {

        // initialize white pieces
        boxes[0][0] = new Box(0, 0, new Rook(true));
        boxes[0][1] = new Box(0, 1, new Knight(true));
        boxes[0][2] = new Box(0, 2, new Bishop(true));
        boxes[0][3] = new Box(0, 3, new Queen(true));
        boxes[0][4] = new Box(0, 4, new King(true));
        boxes[0][5] = new Box(0, 5, new Bishop(true));
        boxes[0][6] = new Box(0, 6, new Knight(true));
        boxes[0][7] = new Box(0, 7, new Rook(true));

        // initialize black pieces
        boxes[7][0] = new Box(0, 0, new Rook(false));
        boxes[7][1] = new Box(0, 1, new Knight(false));
        boxes[7][2] = new Box(0, 2, new Bishop(false));
        boxes[7][3] = new Box(0, 3, new Queen(false));
        boxes[7][4] = new Box(0, 4, new King(false));
        boxes[7][5] = new Box(0, 5, new Bishop(false));
        boxes[7][6] = new Box(0, 6, new Knight(false));
        boxes[7][7] = new Box(0, 7, new Rook(false));

        for (int r = 2; r < 6; r++) {
            for (int c = 0; c < 8; c++) {
                boxes[r][c] = new Box(r, c, null);
            }
        }
    }
}
