package _techlead_coderpro;


import java.util.ArrayList;
import java.util.List;

public class MergeListOfNumberIntoRanges {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5,  7, 8, 9, 9, 10, 11, 15};
        List<String> ranges = findRanges(arr);
        for (String s : ranges) {
            System.out.println(s);
        }
    }

    private static List<String> findRanges(int[] arr) {
        List<String> list = new ArrayList<>();
        if (arr == null || arr.length == 0) return list;

        int low = arr[0];
        int high = arr[0];
        for (int n : arr) {
            if (high + 1 < n) {
                list.add(makeRange(low, high));
                low = n;
            }
            high = n;
        }
        list.add(makeRange(low, high));
        return list;
    }

    private static String makeRange(int low, int high) {
        return low + "->" + high;
    }
}
