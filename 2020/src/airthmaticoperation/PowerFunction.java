package airthmaticoperation;

public class PowerFunction {
    public static void main(String[] args) {
        System.out.println(pow(2, 11));
        System.out.println(pow(3, 5));

        System.out.println(powRec(2, 11));
        System.out.println(powRec(3, 5));
    }

    static int pow(int x, int y) {
        int result = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                result *= x;
            }
            x = x * x;
            y >>= 1;
        }
        return result;
    }

    static int powRec(int x, int y) {
        if (y == 0) return 1;

        if ((y & 1) == 1) {
            return x * powRec(x * x, y >> 1);
        }
        return powRec(x * x, y >> 1);
    }
}
