package _lowleveldesign.chess;

import _lowleveldesign.chess.component.King;
import _lowleveldesign.chess.component.Piece;
import _lowleveldesign.chess.constant.Board;
import _lowleveldesign.chess.constant.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player[] players;
    private List<Move> movesPlayed;
    private Player currentPlayer;
    private GameStatus status;
    private Board board;

    public Game() {
        board = new Board();
        players = new Player[2];
        movesPlayed = new ArrayList<>();
    }

    public void init(Player player1, Player player2) {
        players[0] = player1;
        players[1] = player2;
        board.resetBoard();

        if (player1.isWhiteSide()) {
            this.currentPlayer = player1;
        } else {
            this.currentPlayer = player2;
        }
        movesPlayed.clear();
    }

    public boolean isOver() {
        return status != GameStatus.ACTIVE;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Box start = board.getBox(startX, startY);
        Box end = board.getBox(endX, endY);

        Move move = new Move(player, start, end);
        return this.makeMove(move, player);
    }

    public boolean makeMove(Move move, Player player) {
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) return false;

        if (player != currentPlayer) {
            return false;
        }
        if (sourcePiece.isWhite() == player.isWhiteSide()) {
            return false;
        }

        Piece destPiece = move.getEnd().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        if(sourcePiece instanceof King && ((King) sourcePiece).isCastlingDone()) {
            move.setCastlingMove(true);
        }
        movesPlayed.add(move);

        if(currentPlayer == players[0]) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];

        }
        return false;
    }
}
