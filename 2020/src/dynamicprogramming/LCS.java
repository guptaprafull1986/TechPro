package dynamicprogramming;
/**
 * Longest common subsequence
 * <p>
 * Problem Statement
 * You are given strings
 * s
 * and
 * t
 * . Find one longest string that is a subsequence of both
 * s
 * and
 * t
 * .
 * <p>
 * Notes
 * A subsequence of a string
 * x
 * is the string obtained by removing zero or more characters from
 * x
 * and concatenating the remaining characters without changing the order.
 * <p>
 * Constraints
 * s
 * and
 * t
 * are strings consisting of lowercase English letters.
 * 1
 * ≤
 * |
 * s
 * |
 * ,
 * |
 * t
 * |
 * ≤
 * 3000
 * Input
 * Input is given from Standard Input in the following format:
 * <p>
 * s
 * <p>
 * t
 * <p>
 * Output
 * Print one longest string that is a subsequence of both
 * s
 * and
 * t
 * . If there are multiple such strings, any of them will be accepted.
 * <p>
 * Sample Input 1
 * Copy
 * axyb
 * abyxb
 * Sample Output 1
 * Copy
 * axb
 * The answer is axb or ayb; either will be accepted.
 * <p>
 * Sample Input 2
 * Copy
 * aa
 * xayaz
 * Sample Output 2
 * Copy
 * aa
 * Sample Input 3
 * Copy
 * a
 * z
 * Sample Output 3
 * Copy
 * The answer is  (an empty string).
 * <p>
 * Sample Input 4
 * Copy
 * abracadabra
 * avadakedavra
 * Sample Output 4
 * Copy
 * aaadara
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    char x = s1.charAt(i - 1);
                    char y = s2.charAt(j - 1);

                    if (x == y) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }

        String result = "";

        int i = m;
        int j = n;
        while (i >= 1 && j >= 1) {
            char x = s1.charAt(i - 1);
            char y = s2.charAt(j - 1);
            if (x == y) {
                result = s1.charAt(i - 1) + result;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }

    int lcs(String s1, String s2) {
        if (s1 == null || s1.length() == 0
                || s2 == null || s2.length() == 0) {
            return 0;
        }

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char x = s1.charAt(i);
                char y = s2.charAt(j);
                if (x == y) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    private class Node {
        int value;
        Node next;
    }
    public static Node mergeKSortedLists(Node arr[], int k) {
        Comparator<Node> comparator = new Comparator<>() {
            @Override public int compare(Node x, Node y) {
                return x.value - y.value;
            }
        };
        PriorityQueue<Node> minHeap = new PriorityQueue<>(comparator);

        for(int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        Node head = null;
        Node ptr = null;
        while(!minHeap.isEmpty()) {
            Node temp = minHeap.poll();
            if(temp.next != null) {
                minHeap.add(temp.next);
            }
            temp.next = null;
            if(head == null) {
                head = temp;
            }
            ptr.next = temp;
            ptr = ptr.next;
        }

        return head;
    }

}
