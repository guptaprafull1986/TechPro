package observerpattern;

import java.util.Observable;
import java.util.Observer;

public class GeneralDisplay implements DisplayUnit, Observer {
    @Override
    public void display() {

    }

    @Override
    public void update(Observable observable, Object o) {
        
    }
}
