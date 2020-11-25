package _dynamicprogramming.palindromicsubsequence;

public class UniqueNumberIII {
    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 3, 2, 5};

        int ex = 0;
        for (int n : nums) {
            ex ^= n;
        }

        int a = 0;
        int b = 0;
        int bit = (ex & (~(ex - 1)));
        for (int n : nums) {
            if ((n & bit) == bit) {
                a = a ^ n;
            } else {
                b = b ^ n;
            }
        }

        System.out.println(a + " " + b);
    }
}
