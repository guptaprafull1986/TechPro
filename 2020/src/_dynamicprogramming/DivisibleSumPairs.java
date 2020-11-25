package _dynamicprogramming;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 7, 5, 3};
        int K = 4;
        System.out.println(divisibleSumPair(arr, K));
        System.out.println(divisibleSumPair2(arr, K));

        int[] arr1 = {5, 9, 36, 74, 52, 31, 42};
        int K1 = 3;
        System.out.println(divisibleSumPair(arr1, K1));
        System.out.println(divisibleSumPair2(arr1, K1));
    }

    static int divisibleSumPair(int[] arr, int k) {
        int[] map = new int[k];
        for (int n : arr) {
            map[n % k]++;
        }

        int sum = map[0] * (map[0] - 1) / 2;
        int end = k >> 1;
        for (int i = 1; i <= end; i++) {
            if (i != k - i) {
                sum += map[i] * map[k - i];
            } else {
                sum += map[i] * (map[i] - 1) / 2;
            }
        }

        return sum;
    }

    static int divisibleSumPair2(int[] arr, int k) {
        int sum = 0;
        int[] map = new int[k];

        for (int n : arr) {
            int rem = n % k;

            if (rem != 0) {
                sum += map[k - rem];
            } else {
                sum += map[0];
            }
            map[rem]++;
        }

        return sum;
    }
}
