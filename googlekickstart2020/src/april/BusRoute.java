package april;

import java.util.Scanner;

/**
 * Problem
 * Bucket is planning to make a very long journey across the countryside by bus. Her journey consists of N bus routes, numbered from 1 to N in the order she must take them. The buses themselves are very fast, but do not run often. The i-th bus route only runs every Xi days.
 * <p>
 * More specifically, she can only take the i-th bus on day Xi, 2Xi, 3Xi and so on. Since the buses are very fast, she can take multiple buses on the same day.
 * <p>
 * Bucket must finish her journey by day D, but she would like to start the journey as late as possible. What is the latest day she could take the first bus, and still finish her journey by day D?
 * <p>
 * It is guaranteed that it is possible for Bucket to finish her journey by day D.
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and D. Then, another line follows containing N integers, the i-th one is Xi.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the latest day she could take the first bus, and still finish her journey by day D.
 * <p>
 * Limits
 * Time limit: 10 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 1 ≤ Xi ≤ D.
 * 1 ≤ N ≤ 1000.
 * It is guaranteed that it is possible for Bucket to finish her journey by day D.
 * <p>
 * Test set 1
 * 1 ≤ D ≤ 100.
 * <p>
 * Test set 2
 * 1 ≤ D ≤ 1012.
 * <p>
 * Sample
 * <p>
 * Input
 * <p>
 * Output
 * <p>
 * 3
 * 3 10
 * 3 7 2
 * 4 100
 * 11 10 5 50
 * 1 1
 * 1
 * <p>
 * <p>
 * Case #1: 6
 * Case #2: 99
 * Case #3: 1
 * <p>
 * <p>
 * In Sample Case #1, there are N = 3 bus routes and Bucket must arrive by day D = 10. She could:
 * Take the 1st bus on day 6 (X1 = 3),
 * Take the 2nd bus on day 7 (X2 = 7) and
 * Take the 3rd bus on day 8 (X3 = 2).
 * <p>
 * In Sample Case #2, there are N = 4 bus routes and Bucket must arrive by day D = 100. She could:
 * Take the 1st bus on day 99 (X1 = 11),
 * Take the 2nd bus on day 100 (X2 = 10),
 * Take the 3rd bus on day 100 (X3 = 5) and
 * Take the 4th bus on day 100 (X4 = 50),
 * <p>
 * In Sample Case #3, there is N = 1 bus route and Bucket must arrive by day D = 1. She could:
 * Take the 1st bus on day 1 (X1 = 1).
 */
public class BusRoute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int length = sc.nextInt();
            int days = sc.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }

            int[] dp = new int[arr.length];

            int minDays = days;
            for (int i = 0; i < length; i++) {
                int floor = days / arr[i];
                int minDaysForI = floor * floor * arr[i];
                dp[i] = minDaysForI;
                if (minDays > minDaysForI) {
                    minDays = minDaysForI;
                }
            }

            for (int i = length - 1; i >= 0; --i) {
                if (dp[i] < dp[i - 1]) {
                    break;

                }
            }

            for (int i = length - 1; i >= 0; --i) {
                if (dp[i] > dp[i + 1]) {
                    int floor = dp[i + 1] / arr[i];
                    int minDayForI = floor * arr[i];
                    dp[i] = minDayForI;
                    if (minDayForI < minDays) {
                        minDays = minDayForI;
                    }
                }
            }
            System.out.println("Case #" + t + " " + minDays);
        }
        sc.close();
    }
}
