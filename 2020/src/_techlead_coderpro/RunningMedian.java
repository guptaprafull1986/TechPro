package _techlead_coderpro;

import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        int[] stream = {2, 1, 4, 7, 2, 0, 5};
        int[] median = runningMedian(stream);
        for (int n : median) {
            System.out.print(n + " ");
        }
        System.out.println();

    }

    static int[] runningMedian(int[] stream) {
        int[] median = new int[stream.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> x - y);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

        for (int n : stream) {
            add(n, minHeap, maxHeap);
            balance(minHeap, maxHeap);
            printMedian(minHeap, maxHeap);
        }
        return median;
    }

    private static void printMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

    }

    private static void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

    }

    private static void add(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

    }
}

