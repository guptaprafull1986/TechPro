import java.util.*;

public class mergeArray {
    public static void main(String[] args) {

        /*Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }*/


        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x - y;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(comparator);

        heap.add(10);
        heap.add(20);
        heap.add(3);

        while(!heap.isEmpty()) {
            System.out.println(heap.peek());
            System.out.println(heap.poll());
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 1);
        map.put("C", 2);
        map.put("A", 2);

        System.out.println(map.containsKey("A"));
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(30);
        System.out.println(set.contains(10));
    }


    public static int[] merge(int[] a, int[] b) {
        if(a == null) return b;
        if(b ==  null) return a;

        int m = a.length;
        int n = b.length;
        int[] arr = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m || j < n) {
            int x = i < m ? a[i] : Integer.MAX_VALUE;
            int y = j < n ? b[j] : Integer.MAX_VALUE;

            if(x < y) {
                arr[k++] = x;
                i++;
            } else {
                arr[k++] = y;
                j++;
            }
        }

        return arr;
    }
}
