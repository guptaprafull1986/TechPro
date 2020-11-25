package _designpattern.decorator;

public class CheeseTopping extends Topping {
    private Pizza pizza;

    public CheeseTopping(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", cheese";
    }

    @Override
    public int cost() {
        return pizza.cost() + 30;
    }
}
