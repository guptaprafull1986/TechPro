package _designpattern.adapter.duck;

import _designpattern.adapter.drone.Drone;

public class DroneAdapter implements Duck {
    private Drone drone;

    public DroneAdapter(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void fly() {
        drone.spinRotor();
        drone.takeOff();
    }

    @Override
    public void quack() {
        drone.beep();
    }
}
