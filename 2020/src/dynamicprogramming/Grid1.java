package dynamicprogramming;
/**
 * H - Grid 1 /
 * Time Limit: 2 sec / Memory Limit: 1024 MB
 * <p>
 * Score :
 * 100
 * points
 * <p>
 * Problem Statement
 * There is a grid with
 * H
 * horizontal rows and
 * W
 * vertical columns. Let
 * (
 * i
 * ,
 * j
 * )
 * denote the square at the
 * i
 * -th row from the top and the
 * j
 * -th column from the left.
 * <p>
 * For each
 * i
 * and
 * j
 * (
 * 1
 * ≤
 * i
 * ≤
 * H
 * ,
 * 1
 * ≤
 * j
 * ≤
 * W
 * ), Square
 * (
 * i
 * ,
 * j
 * )
 * is described by a character
 * a
 * i
 * ,
 * j
 * . If
 * a
 * i
 * ,
 * j
 * is ., Square
 * (
 * i
 * ,
 * j
 * )
 * is an empty square; if
 * a
 * i
 * ,
 * j
 * is #, Square
 * (
 * i
 * ,
 * j
 * )
 * is a wall square. It is guaranteed that Squares
 * (
 * 1
 * ,
 * 1
 * )
 * and
 * (
 * H
 * ,
 * W
 * )
 * are empty squares.
 * <p>
 * Taro will start from Square
 * (
 * 1
 * ,
 * 1
 * )
 * and reach
 * (
 * H
 * ,
 * W
 * )
 * by repeatedly moving right or down to an adjacent empty square.
 * <p>
 * Find the number of Taro's paths from Square
 * (
 * 1
 * ,
 * 1
 * )
 * to
 * (
 * H
 * ,
 * W
 * )
 * . As the answer can be extremely large, find the count modulo
 * 10
 * 9
 * +
 * 7
 * .
 * <p>
 * Constraints
 * H
 * and
 * W
 * are integers.
 * 2
 * ≤
 * H
 * ,
 * W
 * ≤
 * 1000
 * a
 * i
 * ,
 * j
 * is . or #.
 * Squares
 * (
 * 1
 * ,
 * 1
 * )
 * and
 * (
 * H
 * ,
 * W
 * )
 * are empty squares.
 * Input
 * Input is given from Standard Input in the following format:
 * <p>
 * H
 * <p>
 * W
 * <p>
 * a
 * 1
 * ,
 * 1
 * …
 * a
 * 1
 * ,
 * W
 * <p>
 * :
 * <p>
 * a
 * H
 * ,
 * 1
 * …
 * a
 * H
 * ,
 * W
 * <p>
 * Output
 * Print the number of Taro's paths from Square
 * (
 * 1
 * ,
 * 1
 * )
 * to
 * (
 * H
 * ,
 * W
 * )
 * , modulo
 * 10
 * 9
 * +
 * 7
 * .
 * <p>
 * Sample Input 1
 * 3 4
 * ...#
 * .#..
 * ....
 * Sample Output 1
 * 3
 * There are three paths as follows:
 * <p>
 * <p>
 * <p>
 * Sample Input 2
 * 5 2
 * ..
 * #.
 * ..
 * .#
 * ..
 * Sample Output 2
 * Copy
 * 0
 * There may be no paths.
 * <p>
 * Sample Input 3
 * 5 5
 * ..#..
 * .....
 * #...#
 * .....
 * ..#..
 * Sample Output 3
 * 24
 * Sample Input 4
 * 20 20
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * Sample Output 4
 * 345263555
 */

import java.util.Scanner;

public class Grid1 {
    private static int R;
    private static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int[][] dp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    if (arr[i][j] == '.') {
                        dp[i][j] = dp[i][j - 1];
                    } else if (arr[i][j] == '#') {
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    if (arr[i][j] == '.') {
                        dp[i][j] = dp[i - 1][j];
                    } else if (arr[i][j] == '#') {
                        dp[i][j] = 0;
                    }
                } else {
                    if (arr[i][j] == '.') {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                }

                dp[i][j] = dp[i][j] % 1000000007;
            }
        }

        System.out.println(dp[R - 1][C - 1]);
        sc.close();
    }
}
