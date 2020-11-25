package codechef;

import java.util.*;

public class KFrequentNumbers {

    public static void main(String[] args) {
        Comparator<Integer> c1 = (x, y) -> y - x;
        Comparator<Integer> c2 = (x, y) -> y - x;
    }

    int[] kFrequentNums(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: arr) {
            int f = 1;
            if(map.containsKey(n)) {
                f += map.get(n);
            }
            map.put(n, f);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (x, y) -> x.getValue() - y.getValue();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue(comparator);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(heap.size() < k) {
                heap.add(entry);
            } else {
                if(heap.peek().getValue() < entry.getValue()) {
                    heap.poll();
                    heap.add(entry);
                }
            }

        }

        return null;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n , 1);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (x, y) -> x.getValue() - y.getValue();

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(comparator);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(heap.size() < k) {
                heap.add(entry);
            } else {
                if(heap.peek().getValue() < entry.getValue()) {
                    heap.poll();
                    heap.add(entry);
                }
            }
        }
        return null;
    }
}