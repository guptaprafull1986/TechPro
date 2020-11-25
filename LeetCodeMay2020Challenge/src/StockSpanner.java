import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class StockSpanner {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    private final Comparator<Integer> minComparator = new Comparator<>() {
        @Override
        public int compare(Integer x, Integer y) {
            return x - y;
        }
    };

    private final Comparator<Integer> maxComparator = new Comparator<>() {
        @Override
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    };

    public StockSpanner() {
        maxHeap = new PriorityQueue(maxComparator);
        minHeap = new PriorityQueue(minComparator);
    }

    public int next(int price) {
        if (maxHeap.isEmpty() || maxHeap.peek() <= price) {
            maxHeap.add(price);
        } else {
            while (!maxHeap.isEmpty() && maxHeap.peek() > price) {
                minHeap.add(maxHeap.poll());
            }
            maxHeap.add(price);
        }

        return maxHeap.size();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> x, Map.Entry<Character, Integer> y) {
                return y.getValue() - x.getValue();
            }
        });

        for (Map.Entry entry : map.entrySet()) {
            heap.add(entry);
        }

        String result = "";

        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.peek();
            char c = entry.getKey();
            int length = entry.getValue();
            int i = 0;
            while (i < length) {
                result += c;
                i++;
            }
        }
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */