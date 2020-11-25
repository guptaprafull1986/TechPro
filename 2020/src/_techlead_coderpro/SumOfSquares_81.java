package _techlead_coderpro;


import java.util.ArrayList;
import java.util.List;

public class SumOfSquares_81 {
    public static void main(String[] args) {
        int num = 13;
        System.out.println(minSumSquare(num));
    }

    private static int minSumSquare(int num) {
        int[] arr = sqrArr(num);

        int[][] dp = new int[arr.length + 1][num + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= num; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = num;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - arr[i - 1]]);
                }
            }
        }

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= num; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[arr.length][num];
    }

    private static int[] sqrArr(int num) {
        List<Integer> list = new ArrayList();

        for (int i = 1; i * i <= num; i++) {
            list.add(i * i);
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer n : list) {
            arr[i++] = n;
        }
        return arr;
    }

    public int mySqrt(int x) {
        if(x == 0) return 0;

        long start = 1;
        long end = x;
        long ans = 1;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            long k = mid * mid;
            if(k == x) {
                return (int)mid;
            } else if(k > x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }

        return (int)ans;
    }
}
