package _designpattern.adapter.duck;

import _designpattern.adapter.drone.SuperDrone;

public class DuckSimulator {
    public static void main(String[] args) {

        Duck mallardDuck = new MallardDuck();
        testDuck(mallardDuck);

        Turkey turkey = new WildTurkey();
        TurkeyAdapter adapter = new TurkeyAdapter(turkey);
        testDuck(adapter);

        DroneAdapter droneAdapter = new DroneAdapter(new SuperDrone());
        testDuck(droneAdapter);
    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
