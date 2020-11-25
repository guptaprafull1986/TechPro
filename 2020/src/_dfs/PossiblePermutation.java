package _dfs;


import java.util.ArrayList;
import java.util.List;

public class PossiblePermutation {
    public static void main(String[] args) {
        List<String> permutation = permutations("abc");
        for (String s : permutation) {
            System.out.println(s);
        }

        List<int[]> list = permutations(new int[]{1, 2, 3});
        for(int[] arr : list) {
            for(int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    static public List<String> permutations(String str) {
        List<String> result = new ArrayList<>();
        permutationUtils("", str, result);
        return result;
    }

    static void permutationUtils(String prefix, String suffix, List<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
            return;
        }

        for (int i = 0; i < suffix.length(); i++) {
            permutationUtils(prefix + suffix.charAt(i),
                    suffix.substring(0, i) + suffix.substring(i + 1),
                    results);
        }
    }

    public static List<int[]> permutations(int[] arr) {
        List<int[]> result = new ArrayList<>();
        permutationUtils(arr, 0, result);
        return result;
    }

    public static void permutationUtils(int[] arr, int index, List<int[]> results) {
        if (index >= arr.length) {
            results.add(arr.clone());
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permutationUtils(arr, index + 1, results);
            swap(arr, index, i);
        }
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
