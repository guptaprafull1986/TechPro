package _designpattern.adapter.drone;

public class SuperDrone implements Drone {
    @Override
    public void beep() {
        System.out.println("Beep Beep Beep");
    }

    @Override
    public void spinRotor() {
        System.out.println("Rotors are spinning");
    }

    @Override
    public void takeOff() {
        System.out.println("Taking off");
    }
}
