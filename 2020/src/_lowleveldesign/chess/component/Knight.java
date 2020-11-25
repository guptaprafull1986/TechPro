package _lowleveldesign.chess.component;

import _lowleveldesign.chess.Box;
import _lowleveldesign.chess.constant.Board;

public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}
