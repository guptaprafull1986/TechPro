package _leetcodegoogle;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNumber {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Comparator<Integer> comp = new Comparator<>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x - y;
            }
        };

        PriorityQueue<Integer> heap = new PriorityQueue<>(comp);
        int i = 0;
        while (i < k) {
            heap.offer(nums[i]);
            i++;
        }

        while (i < nums.length) {
            if (heap.peek() < nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
            i++;
        }

        return heap.peek();
    }
}
