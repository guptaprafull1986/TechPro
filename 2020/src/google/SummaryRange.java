package google;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 7};
        List<String> result = summaryRange(arr);
        for (String s :
                result) {
            System.out.println(s);
        }
    }

    //0 1 2 4 5 7
    public static List<String> summaryRange(int[] arr) {
        List<String> result = new ArrayList<>();

        if (arr.length == 1) {
            result.add(arr[0] + "");
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];

            while (i + 1 < arr.length && arr[i + 1] - arr[i] == 1) {
                i++;
            }
            if (n != arr[i]) {
                result.add(n + "->" + arr[i]);
            } else {
                result.add(n + "");
            }
        }
        return result;
    }
}
