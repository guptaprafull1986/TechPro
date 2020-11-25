package _lowleveldesign.chess;

public class Player {
    private Person person;
    private boolean whiteSide = false;

    public Player(Person person, boolean whiteSide) {
        this.person = person;
        this.whiteSide = whiteSide;
    }

    boolean isWhiteSide() {
        return whiteSide;
    }

}
