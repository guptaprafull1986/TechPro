package _lowleveldesign.chess.component;

import _lowleveldesign.chess.Box;
import _lowleveldesign.chess.constant.Board;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}
