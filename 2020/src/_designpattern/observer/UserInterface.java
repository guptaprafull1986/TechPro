package _designpattern.observer;

public class UserInterface implements Observer {

    private Subject subject;

    public UserInterface(Subject subject) {
        this.subject = subject;
    }

    public void display() {

    }

    @Override
    public void update(int value) {

    }
}
