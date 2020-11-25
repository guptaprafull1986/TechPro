package _designpattern.observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherStation implements Subject {
    Set<Observer> set;
    private int temperature;
    private int windSpeed;
    private int pressure;

    public WeatherStation() {
        set = new HashSet<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if(!set.contains(observer)) {
            set.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!set.contains(observer)) {
            set.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : set) {
            o.update(temperature);
        }
    }
}
