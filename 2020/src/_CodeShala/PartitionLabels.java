package _CodeShala;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * <p>
 * <p>
 * Note:
 * <p>
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */
public class PartitionLabels {
    public static void main(String[] args) {
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        for(int n : list) {
            System.out.print(n + " ");
        }
        System.out.println();

    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if (S == null || S.length() == 0) return list;

        int[] map = new int[26];

        int index = 0;
        for (char c : S.toCharArray()) {
            map[c - 'a'] = index + 1;
            index++;
        }

        int n = S.length();
        int prev = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int count = map[S.charAt(i) - 'a'];
            if (count > max) {
                max = count;
            }

            if (max - 1 == i) {
                int len = max - prev;
                list.add(len);
                prev = max;
            }
        }
        return list;
    }
}
