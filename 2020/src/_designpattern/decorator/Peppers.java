package _designpattern.decorator;

public class Peppers extends Topping {
    private Pizza pizza;

    public Peppers(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Peppers";
    }

    @Override
    public int cost() {
        return pizza.cost() + 60;
    }
}
