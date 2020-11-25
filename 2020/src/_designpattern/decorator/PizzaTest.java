package _designpattern.decorator;

public class PizzaTest {
    public static void main(String[] args) {
        Pizza pizza = new ThickCrustPizza();
        pizza = new Olives(pizza);
        pizza = new Olives(pizza);
        pizza = new CheeseTopping(pizza);
        pizza = new CheeseTopping(pizza);
        System.out.println("Description : " + pizza.getDescription());
        System.out.println("cost(INR) : " + pizza.cost());

        Pizza pizza2 = new ThinCrustPizza();
        pizza2 = new Olives(pizza2);
        pizza2 = new Olives(pizza2);
        pizza2 = new CheeseTopping(pizza2);
        pizza2 = new CheeseTopping(pizza2);
        System.out.println("Description : " + pizza2.getDescription());
        System.out.println("cost(INR) : " + pizza2.cost());

    }
}
