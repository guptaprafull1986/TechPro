/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2, 0, 0}));
        System.out.println(canJump(new int[]{0}));
    }

    public static boolean canJump(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0) {
                return false;
            }

            if (nums[i] < nums[i - 1]) {
                nums[i] = nums[i - 1] - 1;
            }
        }

        return true;
    }
}
