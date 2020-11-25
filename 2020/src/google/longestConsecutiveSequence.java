package google;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSequence {

    public static void main(String[] args) {

        int[] arr = {7, 100, 3, 2, 4, 1, 200, 99, 101, 103, 5, 102, 98, 6};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] arr) {
        int max = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (!set.contains(current)) {
                continue;
            }

            set.remove(current);
            int down = current;
            while (set.contains(current - 1)) {
                down--;
                set.remove(current - 1);
                current--;
            }

            current = arr[i];
            int up = current;
            while (set.contains(current + 1)) {
                up++;
                set.remove(current + 1);
                current++;
            }
            max = Math.max(max, up - down + 1);
        }

        return max;
    }

}
