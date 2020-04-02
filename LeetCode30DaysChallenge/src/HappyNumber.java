import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        boolean isHappy = happyNumber(19);
        System.out.println(isHappy);
    }

    private static boolean happyNumber(int n) {
        Map<Integer, Boolean> map = new HashMap<>();
        while (!map.containsKey(n)) {
            map.put(n, true);
            int temp = n;
            int sum = 0;
            while (temp > 0) {
                int x = temp % 10;
                temp = temp / 10;
                sum += x * x;
            }

            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }
}
