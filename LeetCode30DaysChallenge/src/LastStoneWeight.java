import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{5,1,8,10,7}));
    }

    public static int lastStoneWeight(int[] stones) {
       MaxHeap heap = new MaxHeap(stones.length);
        for (int num : stones) {
            heap.add(num);
        }
        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            if (x != y) {
                heap.add(Math.abs(x - y));
            }
        }
        if (heap.isEmpty()) {
            return 0;
        }
        return heap.poll();
    }
}

class MaxHeap {
    int[] arr;
    int length;

    MaxHeap(int length) {
        this.length = 0;
        arr = new int[length + 1];
    }

    boolean isEmpty() {
        return length == 0;
    }

    int size() {
        return length;
    }

    void add(int num) {
        arr[length] = num;
        int child = length;
        int parent = (child - 1) / 2;

        while (child != 0 && arr[child] > arr[parent]) {
            int temp = arr[child];
            arr[child] = arr[parent];
            arr[parent] = temp;
            child = parent;
            parent = (child - 1) / 2;
        }
        length++;
    }

    int poll() {
        int value = arr[0];
        arr[0] = arr[length - 1];
        length--;
        shiftDown(0);
        return value;
    }

    private void shiftDown(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int minIndex;
        if (right > length) {
            if (left > length) {
                return;
            }
            minIndex = length;
        } else {
            if (arr[left] > arr[right]) {
                minIndex = left;
            } else {
                minIndex = right;
            }
        }

        if (arr[minIndex] > arr[parent]) {
            int temp = arr[minIndex];
            arr[minIndex] = arr[parent];
            arr[parent] = temp;
            shiftDown(minIndex);
        }
    }
}