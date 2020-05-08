/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;

        for (int n : nums) {
            if (count == 0) {
                majority = n;
                count++;
            } else if (majority == n) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        int target = nums.length >> 1;
        for (int n : nums) {
            if (majority == n) {
                count++;
                if (count > target) {
                    return majority;
                }
            }
        }

        return -1;
    }
}
