package _leetcodegoogle;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        Comparator<Integer> comp = new Comparator<>() {
            @Override
            public int compare(Integer o, Integer t1) {
                return 0;
            }
        };
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println("result : " + minWindow(S, T));
    }

    static public String minWindow(String s, String t) {
        int[] map = new int[26];
        for (char c : t.toCharArray()) {
            map[c - 'A']++;
        }

        int start = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int in = s.charAt(i) - 'A';
            if (map[in] != 0) {
                hash[in]++;
            }
            while (Arrays.equals(map, hash)) {
                int length = i - start + 1;
                if (min > length) {
                    min = length;
                    result = s.substring(start, i + 1);
                }
                in = s.charAt(start) - 'A';
                if (hash[in] > 0) {
                    hash[in]--;
                }
                start += 1;
            }
        }
        return result;
    }
}
