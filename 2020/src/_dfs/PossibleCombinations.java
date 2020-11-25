package _dfs;

import java.util.ArrayList;
import java.util.List;

public class PossibleCombinations {
    public static void main(String[] args) {
        int[] n = {1, 2, 3};
        List<List<Integer>> list = combinations(n);
        for(List<Integer> item : list) {
            System.out.println(item);
        }
    }

    private static List<List<Integer>> results;

    static List<List<Integer>> combinations(int[] n) {
        results = new ArrayList<>();
        utils(n, 0, new ArrayList<>());
        return results;
    }

    static public void utils(int[] arr, int index, List<Integer> path) {
        if (index >= arr.length) {
            results.add(path);
            return;
        }

        List<Integer> list = new ArrayList<>(path);
        list.add(arr[index]);

        utils(arr, index + 1, list);
        utils(arr, index + 1, path);
    }

}
