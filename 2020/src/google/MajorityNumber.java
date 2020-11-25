package google;

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
 * Input: [2,2,1,1
 * Output: -1
 */

import java.util.HashMap;
import java.util.Map;

/**
 * *********** Majority Voting Algorithm **************
 * Refer Below link
 * https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
 */
public class MajorityNumber {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1}));
    }

    public static int majorityElement(int[] nums) {

        int count = 0;
        int majority = nums[0];
        for (int n : nums) {
            if (count == 0) {
                majority = n;
                count = 1;
            } else if (majority == n) {
                count++;
            } else {
                count--;
            }
        }
        int target = nums.length >> 1;

        count = 0;
        for (int n : nums) {
            if (n == majority) {
                count++;

                if (count > target) {
                    return majority;
                }
            }
        }

        if (count > target)
            return majority;

        return -1;
    }

    public static int majorityElementUsingMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int target = nums.length >> 1;
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }

            max = Math.max(max, map.get(n));
            if (max > target) {
                return n;
            }
        }

        return -1;
    }
}
