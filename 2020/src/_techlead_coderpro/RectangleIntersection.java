package _techlead_coderpro;

public class RectangleIntersection {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(0, 0, 3, 2);
        Rectangle b = new Rectangle(1, 1, 3, 3);
        System.out.println(intersect_rectangle(a, b));
    }

    private static int intersect_rectangle(Rectangle a, Rectangle b) {
        Rectangle rect = new Rectangle(Math.max(a.minX, b.minX), Math.max(a.minY, b.minY),
                Math.max(a.maxX, b.maxX), Math.max(a.maxY, b.maxY));
        return rect.area();
    }
}

class Rectangle {
    int minX;
    int minY;
    int maxX;
    int maxY;

    Rectangle(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    int area() {
        if (minX >= maxX) return 0;
        if (minY >= maxY) return 0;

        return (maxX - minX) * (maxY - minY);
    }
}
