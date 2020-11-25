/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
//        System.out.println(isPerfectSquare(10));
        int x = Integer.MAX_VALUE;
//        System.out.println(isPerfectSquare(2147483646));
        System.out.println(isPerfectSquare(2147395600));
        System.out.println(Math.sqrt(2147483647));
        System.out.println(Math.sqrt(2147395600));
    }

    public static boolean isPerfectSquare_binarySearch(int num) {
        long start = 1;
        long end = num;

        while (start <= end) {
            long mid = (start + end) >> 1;
            long sqr = mid * mid;
            if (sqr == num) return true;
            else if (sqr < num) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    public static boolean isPerfectSquare(int num) {

        if (Integer.MAX_VALUE == num) return false;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0 && (num / i == i)) {
                return true;
            }
        }

        return false;
    }
}
