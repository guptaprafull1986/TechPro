package _slidingwindow;

public class MaximumSumSubarrayOfK {
    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(findMaxSumSubArray2(3, new int[]{2, 1, 5, 1, 3, 2}));
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = 0;
        int sum = 0;
        int i = 0;
        while (i < k) {
            sum += arr[i];
            i++;
        }
        max = Math.max(max, sum);

        while (i < arr.length) {
            sum = sum + arr[i] - arr[i - k];
            max = Math.max(max, sum);
            i++;
        }
        max = Math.max(max, sum);
        return max;
    }

    public static int findMaxSumSubArray2(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0;
        int end = 0;
        for (; end < k; end++) {
            windowSum += arr[end];
        }
        maxSum = windowSum;
        System.out.print(maxSum + ": ");
        int start = 0;
        for (; end < arr.length; end++) {
            windowSum += arr[end] - arr[start++];
            maxSum = Math.max(maxSum, windowSum);
            System.out.print(maxSum + ", ");
        }

        return maxSum;

    }
}
