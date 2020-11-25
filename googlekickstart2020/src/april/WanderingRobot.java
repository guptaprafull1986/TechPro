package april;

import java.util.Scanner;

public class WanderingRobot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[] start = new int[2];
        int[] end = new int[2];
        int row;
        int col;
        for (int t = 1; t <= testCases; t++) {
            col = sc.nextInt();
            row = sc.nextInt();
            start[0] = sc.nextInt();
            start[1] = sc.nextInt();
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();

            int[][] arr = new int[row + 1][col + 1];

            for (int i = start[1]; i <= end[1]; i++) {
                for (int j = start[0]; j <= end[0]; j++) {
                    arr[i][j] = 1;
                }
            }
            double probability = calculateProb(arr, row, col);
            System.out.println("Case #" + t + " " + probability);
        }
        sc.close();
    }

    private static double calculateProb(int[][] arr, int row, int col) {
        double[][] dp = new double[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else if (i == 1) {
                    dp[i][j] = arr[i][j] == 0 ? dp[i][j - 1] : 0;
                } else if (j == 1) {
                    dp[i][j] = arr[i][j] == 0 ? dp[i - 1][j] : 0;
                } else {
                    if (arr[i][j] == 1 || (dp[i - 1][j] == 0 && dp[i][j - 1] == 0)) {
                        dp[i][j] = 0;
                    } else {
                        if (dp[i - 1][j] == dp[i][j - 1]) {
                            dp[i][j] = dp[i - 1][j] + 1;
                        } else {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }
                }
            }
        }
        if (dp[row][col] == 0) return 0;
        return 1.0 / dp[row][col];
    }
}

/**
 * Competitive Submissions
 * You have not attempted this problem.
 * Last updated: Apr 19 2020, 05:49
 * <p>
 * Problem
 * Jemma is competing in a robotics competition. The challenge for today is to build a robot that can navigate around a hole in the arena.
 * <p>
 * The arena is a grid of squares containing W columns (numbered 1 to W from left to right) and H rows (numbered 1 to H from top to bottom). The square in the x-th column and y-th row is denoted (x, y). The robot begins in the top left square (1,1) and must navigate to the bottom right square (W, H).
 * <p>
 * A rectangular subgrid of squares has been cut out of the grid. More specifically, all the squares that are in the rectangle with top-left square (L, U) and bottom-right square (R, D) have been removed.
 * <p>
 * Jemma did not have much time to program her robot, so it follows a very simple algorithm:
 * If the robot is in the rightmost column, it will always move to the square directly below it. Otherwise,
 * If the robot is in the bottommost row, it will always move to the square directly right of it. Otherwise,
 * The robot will randomly choose to either move to the square directly to the right, or to the square directly below it with equal probability.
 * <p>
 * Jemma passes the challenge if her robot avoids falling into the hole and makes it to the square (W, H). What is the probability she passes the challenge?
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line containing W, H, L, U, R and D.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is a real number between 0 and 1 inclusive, the probability that Jemma passes the challenge.
 * <p>
 * y will be considered correct if it is within an absolute or relative error of 10-5 of the correct answer. See the FAQ for an explanation of what that means, and what formats of real numbers we accept.
 * <p>
 * Limits
 * Time limit: 15 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 1 ≤ U ≤ D ≤ H.
 * 1 ≤ L ≤ R ≤ W.
 * Neither the top-left nor bottom-right squares will be missing.
 * <p>
 * Test set 1
 * 1 ≤ W ≤ 300.
 * 1 ≤ H ≤ 300.
 * <p>
 * Test set 2
 * 1 ≤ W ≤ 105.
 * 1 ≤ H ≤ 105.
 * <p>
 * Sample
 * <p>
 * Input
 * <p>
 * Output
 * <p>
 * 4
 * 3 3 2 2 2 2
 * 5 3 1 2 4 2
 * 1 10 1 3 1 5
 * 6 4 1 3 3 4
 * <p>
 * <p>
 * Case #1: 0.5
 * Case #2: 0.0625
 * Case #3: 0.0
 * Case #4: 0.3125
 */