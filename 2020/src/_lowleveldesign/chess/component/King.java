package _lowleveldesign.chess.component;

import _lowleveldesign.chess.Box;
import _lowleveldesign.chess.constant.Board;

public class King extends Piece {
    private boolean isCastlingDone = false;

    public King(boolean white) {
        super(white);
    }

    public boolean isCastlingDone() {
        return isCastlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        isCastlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (this.isWhite() == end.getPiece().isWhite()) return false;

        int x = Math.abs(start.getRow() - end.getRow());
        int y = Math.abs(start.getCol() - end.getCol());

        if(x + y == 1) return true;

        return isValidCastling(board, start, end);
    }

    private boolean isValidCastling(Board board, Box start, Box end) {
        if(isCastlingDone) return false;
        if(this.isWhite() && start.getRow() == 0 && start.getCol() == 4 && end.getCol() == 0) {
            if(Math.abs(start.getCol() - end.getCol()) == 2) {

                // check for all the condition to make sure, this is casting move
                this.setCastlingDone(true);
                return true;
            } else {
                // check for black
            }
        }
        return false;
    }
}
