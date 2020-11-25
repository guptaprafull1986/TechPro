package _leetcodegoogle;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosedPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return area(y) - area(x);
            }
        };

        PriorityQueue<int[]> heap = new PriorityQueue(comparator);

        for(int[] p : points) {
            if(heap.size() < K) {
                heap.add(p);
            } else {
                if(area(heap.peek()) > area(p)) {
                    heap.poll();
                    heap.add(p);
                }
            }
        }

        int[][] result = new int[K][2];
        int index = K - 1;
        while(!heap.isEmpty()) {
            result[index--] = heap.poll();
        }

        return result;
    }

    int area(int[] x) {
        return x[0] * x[0] + x[1] * x[1];
    }
}
