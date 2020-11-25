package _techlead_coderpro;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int n = 242;
        System.out.println(maxConsecutiveOnes(n));
    }

    private static int maxConsecutiveOnes(int n) {

        int max = 0;
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }

            n >>= 1;
        }
        return max;
    }
}
