package _slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationInAString {

    public static void main(String[] args) {

    }

    static boolean permutationInAString(String s2, String s1/*pattern*/) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;

        int m = s1.length();
        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }
        int[] map = new int[26];

        int i = 0;
        for (char c : s2.toCharArray()) {
            map[c - 'a']++;
            if (i >= m) {
                int prev = s2.charAt(i - m) - 'a';
                map[prev]--;
            }

            if (Arrays.equals(map, hash)) {
                return true;
            }
            i++;
        }
        return false;
    }

    static public List<String> findAnagrams(String s, String p) {
        List<String> list = new ArrayList<>();
        if(s == null || p == null || p.length() > s.length()) return list;

        int m = p.length();
        int[] hash = new int[26];
        for(char c : p.toCharArray()) {
            hash[c - 'a']++;
        }

        int[] map = new int[26];
        int i = 0;
        for(char c : s.toCharArray()) {
            map[c - 'a']++;
            if(i >= m) {
                int prev = s.charAt(i - m) - 'a';
                map[prev]--;
            }

            if(Arrays.equals(map, hash)) {
                list.add(s.substring(i - m + 1, i));
            }
            i++;
        }
        return list;
    }
}
