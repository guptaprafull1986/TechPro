package _designpattern.adapter.duck;

public class MallardDuck implements Duck {
    @Override
    public void fly() {
        System.out.println("Duck fly");
    }

    @Override
    public void quack() {
        System.out.println("Duck quack");
    }
}
