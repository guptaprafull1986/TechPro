package _lowleveldesign.chess.component;

import _lowleveldesign.chess.Box;
import _lowleveldesign.chess.constant.Board;

public abstract class Piece {
    private boolean isKilled = false;
    private boolean isWhite = false;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public void setWhite(boolean isWhile) {
        this.isWhite = isWhile;
    }

    public abstract boolean canMove(Board board, Box start, Box end);

}
