package _techlead_coderpro;

public class MaxSumSubarray {
    public static void main(String[] args) {
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = {-1, -4, 3, 8, 1};

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : arr) {
            sum += n;
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
