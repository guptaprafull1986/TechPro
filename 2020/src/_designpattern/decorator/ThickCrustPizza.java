package _designpattern.decorator;

public class ThickCrustPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Thick crust pizza";
    }

    @Override
    public int cost() {
        return 250;
    }
}
