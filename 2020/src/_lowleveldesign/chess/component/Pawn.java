package _lowleveldesign.chess.component;

import _lowleveldesign.chess.Box;
import _lowleveldesign.chess.constant.Board;

public class Pawn extends Piece {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}
