package _lowleveldesign.chess.component;

import _lowleveldesign.chess.Box;
import _lowleveldesign.chess.constant.Board;

public class Bishop extends Piece {

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}
