/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        for (int i = 0; i < n; i++) {
            product[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }

        int mul = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            product[i] = product[i] * mul;
            mul *= nums[i];
        }

        return product;
    }
}

