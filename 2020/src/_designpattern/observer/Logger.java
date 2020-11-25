package _designpattern.observer;

public class Logger implements Observer {

    private Subject subject;

    public Logger(Subject subject) {
        this.subject = subject;
    }

    public void log() {

    }

    @Override
    public void update(int value) {

    }
}
