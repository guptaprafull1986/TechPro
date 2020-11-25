package _lowleveldesign.chess;

import _lowleveldesign.chess.component.Piece;

public class Move {
    private Player player;
    private Box start;
    private Box end;
    private Piece killedPiece;
    private Piece pieceMoved;
    private boolean isCastlingMove;

    public Move(Player player, Box start, Box end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public Box getStart() {
        return start;
    }

    public Box getEnd() {
        return end;
    }

    public void setPieceKilled(Piece destPiece) {
        killedPiece = destPiece;
    }

    public void setCastlingMove(boolean isCastlingMove) {
        this.isCastlingMove = isCastlingMove;
    }
}
