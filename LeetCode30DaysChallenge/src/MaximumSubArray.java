/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(num));
        int[] arr = {-1};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int max = Integer.MIN_VALUE;
        int min = 0;

        for (int i = 0; i < nums.length; i++) {
            maxSoFar += nums[i];
            if (maxSoFar >= 0 && max < maxSoFar) {
                max = maxSoFar;
            }

            if (nums[i] < 0 && (min == 0 || min < nums[i])) {
                min = nums[i];
            }
            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }

        if (max < 0) {
            max = min;
        }

        return max;
    }
}

