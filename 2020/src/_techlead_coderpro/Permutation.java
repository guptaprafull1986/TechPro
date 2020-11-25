package _techlead_coderpro;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr, 0);
    }

    private static void permute(int[] arr, int start) {
        if (start == arr.length) {
            for (int n :
                    arr) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            permute(arr, start + 1);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    void dummy() {
        String s = "4,2,#,3,#,#,5,#,#";
        String[] arr = s.split(",");
    }
}
