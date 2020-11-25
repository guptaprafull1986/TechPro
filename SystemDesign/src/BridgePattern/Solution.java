package BridgePattern;

public class Solution {
    public static void main(String[] args) {
        Shape shape = new Triangle(new Red());
        shape.draw();
        shape = new Pentagon(new Red());
        shape.draw();
        shape = new Triangle(new Yellow());
        shape.draw();
        shape = new Pentagon(new Red());
        shape.draw();
    }
}
