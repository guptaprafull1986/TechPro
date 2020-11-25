package qualityQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * A team of geologists attempting to measure the differences in carbon dated volcanic materials and non-volcanic materials.
 * You need to compare the volcanic material with non volcanic material of the same carbon dated age in-order to establish a base for testing.
 * You are given two array volcanic and non-volcanic. Find a list of materials with identical tes between both arrays.
 * Return this list in descending order (i.e. highest age followed by second highest, with the lowest age at the end.)
 *
 * For example, you are given following two arrays:
 * volcanic = [7000, 13400, 7000, 14000] and
 * nonVolcanic = [7000, 13400, 150000, 7000]
 * your return array should show: result = [13400, 7000, 7000]
 *
 * The data=e 7000 is present in both the arrays. Therefore there are two matches and both should present in result array.
 */
public class GeologicalSorting {

    public static void main(String[] args) {
        int[] volcanic = {7000, 13400, 7000, 14000};
        int[] nonVolcanic = {7000, 13400, 150000, 7000};
        int[] sortedArray = geologicalSorting(volcanic, nonVolcanic);
        printArray(sortedArray);
    }

    private static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static int[] geologicalSorting(int[] volcanic, int[] nonVolcanic) {

        if (volcanic.length > nonVolcanic.length) {
            int[] temp = volcanic;
            volcanic = nonVolcanic;
            nonVolcanic = temp;
        }

        Map<Integer, Integer> map = getMap(volcanic);
        PriorityQueue<Integer> minHeap = getHeap(nonVolcanic, map);
        int[] result = new int[minHeap.size()];

        int i = result.length - 1;
        while (!minHeap.isEmpty()) {
            result[i--] = minHeap.poll();
        }
        return result;
    }

    private static PriorityQueue<Integer> getHeap(int[] arr, Map<Integer, Integer> map) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int n : arr) {
            if (map.containsKey(n) && map.get(n) > 0) {
                heap.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        return heap;
    }

    private static Map<Integer, Integer> getMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        return map;
    }
}
