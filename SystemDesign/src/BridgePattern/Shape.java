package BridgePattern;

public abstract class Shape {

    protected Color color;

    Shape(Color color) {
        this.color = color;
    }

    public void draw() {
        System.out.println(color.getColor() + " color "+ getShareName());
    }

    abstract String getShareName();
}
