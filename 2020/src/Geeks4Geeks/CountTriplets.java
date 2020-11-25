package Geeks4Geeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountTriplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            Map<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], true);
            }

            // Algo start

            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (map.containsKey(arr[i] + arr[j])) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            // Algo end
        }
        sc.close();
    }
}
