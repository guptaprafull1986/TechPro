package _designpattern.decorator;

public class ThinCrustPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Thin crust pizza";
    }

    @Override
    public int cost() {
        return 300;
    }
}
