package qualityQuestions;

import java.util.PriorityQueue;

/**
 * Given am array of integers, perform some number 'k' of operations.
 * Each operation consists of removing an element from the array,
 * dividing it by 2 and inserting the ceiling of that result back to array.
 * Minimize e sum of elements in the final array.
 * <p>
 * Example :
 * nums = [10, 20, 7]
 * k = 4
 * <p>
 * initial array  [10, 20, 7]
 * pick     pick/2      Ceiling     Result
 * 7        3.5         4          [10, 20, 4]
 * 10       5           5          [5, 20, 4]
 * 20      10          10          [5, 10, 4]
 * 10      5           5           [5, 5, 4]
 * <p>
 * The sum of final array is 5 + 5 + 4 = 14, and this sum is minimal.
 * <p>
 * Function description:
 * Complete the function minSum in the editor below.
 * minSum has the following parameters.
 * int nums[n] : an integer array on length n
 * nit k: an integer
 * <p>
 * Returns int : the minimum sum of the array after k steps
 * <p>
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= 10^4 (where 0 <= i < n)
 * 1 <= k <= 10^7
 */
public class MinimumSum {
    public static void main(String[] args) {
        System.out.println(minSum(new int[]{10, 20, 4}, 4));
        System.out.println(minSum(new int[]{10, 20, 7}, 6));
        System.out.println(minSum(new int[]{10, 20, 7}, 30));
        System.out.println(minSum(new int[]{1, 1, 1}, 60000));
    }

    static int minSum(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);

        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }

        int i = 1;
        while (i <= k && heap.peek() != 1) {

            int num = heap.poll();

            num = (num & 1) == 1 ? (num + 1) >> 1 : num >> 1;
            heap.add(num);
            i++;
        }

        int sum = 0;
        if (i < k) {
            sum = nums.length;
        } else {
            int count = 1;

            while (!heap.isEmpty()) {
                int value = heap.poll();
                if (value != 1) {
                    sum += value;
                    count++;

                } else {
                    sum += (nums.length - count);
                    break;
                }
            }
        }
        return sum;
    }
}
