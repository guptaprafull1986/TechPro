package strategypattern;

public class Duck {
    IFlyBehavior flyBehavior;
    IDisplayBehavior displayBehavior;
    IEatBehavior eatBehavior;

    public Duck() {

    }
}
