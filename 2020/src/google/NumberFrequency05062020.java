package google;

public class NumberFrequency05062020 {

    public static void main(String[] args) {
        System.out.println(isValidNumber(21343234, 2));
        System.out.println(isValidNumber(23334234, 2));
    }

    static boolean isValidNumber(int num, int k) {
        int n = 0;
        int count = 0;
        while (num > 0) {
            int x = num % 10;
            if (x == n) {
                count++;
                if (count > k) {
                    return false;
                }
            } else {
                n = x;
                count = 1;
            }
            num /= 10;
        }
        return true;
    }
}
