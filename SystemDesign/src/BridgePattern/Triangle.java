package BridgePattern;

public class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }

    @Override
    String getShareName() {
        return Triangle.class.getSimpleName();
    }
}
