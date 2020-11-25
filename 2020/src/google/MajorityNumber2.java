package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * Input: [6, 5, 5]
 * Output: [5]
 */
public class MajorityNumber2 {
    public static void main(String[] args) {
        List<Integer> list = majorityElement(new int[]{6, 5, 5});
        printList(list);
        list = majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
        printList(list);
    }

    private static void printList(List<Integer> list) {
        for (int n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        int m1 = nums[0];
        int m2 = nums[0];
        int c1 = 0;
        int c2 = 0;

        for (int n : nums) {
            if (n == m1) {
                c1++;
            } else if (n == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        int target = nums.length / 3;
        c1 = c2 = 0;
        for (int n : nums) {
            if (n == m1) {
                c1++;
            } else if (n == m2) {
                c2++;
            }
        }

        if (c1 > target) {
            result.add(m1);
        }
        if (c2 > target) {
            result.add(m2);
        }

        return result;
    }
}
