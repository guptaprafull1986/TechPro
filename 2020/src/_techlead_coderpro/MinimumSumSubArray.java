package _techlead_coderpro;

public class MinimumSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minSumSubarray(arr, 7));
        ;
    }

    private static int minSumSubarray(int[] arr, int k) {
        int min = arr.length;

        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (sum >= k) {
                min = Math.min(min, end - start + 1);
                sum -= arr[start];
                start++;
            }
            end++;
        }
        return min;
    }
}

