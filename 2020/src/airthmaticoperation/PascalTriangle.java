package airthmaticoperation;

import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        Collections.singletonList(arr);
        List<List<Integer>> list = generate(5);
        for (List<Integer> item :
                list) {
            for (Integer n :
                    item) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                } else {
                    List<Integer> prev = list.get(i - 1);
                    int sum = prev.get(j - 1) + prev.get(j);
                    item.add(sum);
                }
            }
            list.add(item);
        }
        return list;
    }


}
