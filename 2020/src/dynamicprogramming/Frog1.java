package dynamicprogramming;

import java.util.Scanner;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(execute(arr, n));
        sc.close();
    }

    private static int execute(int[] arr, int length) {
        int first = 0;
        int second = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.min(first + Math.abs(arr[i] - arr[i - 2]), second + Math.abs(arr[i] - arr[i - 1]));
            first = temp;
        }
        return second;
    }
}
