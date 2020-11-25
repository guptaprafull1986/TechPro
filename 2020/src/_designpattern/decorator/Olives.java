package _designpattern.decorator;

public class Olives extends Topping {
    private Pizza pizza;

    public Olives(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public int cost() {
        return pizza.cost() + 60;
    }
}
