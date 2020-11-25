package qualityQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class InterleavingString {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> {
            int diff = x - y;
            return diff;
        });

        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(4);
        priorityQueue.add(110);
        priorityQueue.add(1);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
        isInterleavingString("AAB", "AAC", "AABDAAC");
    }

    static boolean isInterleavingString(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                // s1 is empty
                else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(j - 1) ? dp[i][j - 1] : false;
                }

                // s2 is empty
                else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i - 1) ? dp[i - 1][j] : false;
                } else {

                    char a = s1.charAt(i - 1);
                    char b = s2.charAt(j - 1);
                    char c = s3.charAt(i + j - 1);
                    if (a == c && b == c) {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (a == c) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (b == c) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        printArray(dp);
        return dp[m][n];
    }

    private static void printArray(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) System.out.print("T ");
                else System.out.print("F ");
            }
            System.out.println();
        }
    }
}
