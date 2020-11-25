package _designpattern.observer;

public class Alert implements Observer {
    private Subject subject;

    public Alert(Subject subject) {
        this.subject = subject;
    }

    public void alert() {

    }

    @Override
    public void update(int value) {

    }
}
