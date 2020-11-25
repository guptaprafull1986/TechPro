package dynamicprogramming;

import java.util.Scanner;

public class Main {
    private static int R;
    private static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        char[][] arr = new char[R + 1][C + 1];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r][c] = 1;
        }

        int[][] dp = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {

                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else if (i == 1) {
                    dp[i][j] = arr[i][j] == 1 ? 0 : dp[i][j - 1];
                } else if (j == 1) {
                    dp[i][j] = arr[i][j] == 1 ? 0 : dp[i - 1][j];
                } else {
                    if (arr[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - 1] +  dp[i - 1][j];
                    }
                }
            }

        }

        int answer = dp[R][C] % 1000000007;
        System.out.println(answer);
        sc.close();
    }
}
