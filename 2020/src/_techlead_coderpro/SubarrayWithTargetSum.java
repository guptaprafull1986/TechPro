package _techlead_coderpro;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithTargetSum {
    public static void main(String[] args) {

        int[] result = find_continuous_k(new int[]{1, 3, 2, 5, 7, 2}, 14);
        if (result == null) {
            System.out.println("no subarray found");
            return;
        }
        for (int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static int[] find_continuous_k(int[] arr, int k) {

        int sum = 0;
        int start = -1;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > k) {
                if (map.containsKey(sum - k)) {
                    start = map.get(sum - k) + 1;
                    end = i;
                    break;
                }
            }
            map.put(sum, i);
        }

        if (start == -1) {
            return null;
        }
        int[] result = new int[end - start + 1];
        int x = 0;
        for (int i = start; i <= end; i++) {
            result[x++] = arr[i];
        }
        return result;
    }
}
