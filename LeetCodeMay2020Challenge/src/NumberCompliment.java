/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class NumberCompliment {

    public static void main(String[] args) {
        System.out.println(findComplement(3234));
        System.out.println(findComplement(5));
        System.out.println(findComplement(16));
        System.out.println(findComplement(32));
        System.out.println(findComplement(1));
        System.out.println(findComplement(0));
        System.out.println(findComplement(87));
        System.out.println(findComplement(9677));
    }

    public static int findComplement(int num) {
        int n = num;
        int sum = 0;
        while (n > 0) {
            sum = (sum << 1) + 1;
            n = n >> 1;
        }

        return sum - num;
    }

    public static int findComplement_2(int num) {
        if (num == 0) return 1;
        if (num == 1) return 0;

        int result = 0;
        int i = 1;
        while (num > 0) {
            if ((num & 1) == 0) {
                result += i;
            }
            i = i << 1;
            num = num >> 1;
        }
        return result;
    }

}
