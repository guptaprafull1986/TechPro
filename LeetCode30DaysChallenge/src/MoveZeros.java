import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 3, 12};
        int[] arr = {5, 7, 8, 0, 8, 0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {

        int i = 0;
        int index = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
            i++;
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
