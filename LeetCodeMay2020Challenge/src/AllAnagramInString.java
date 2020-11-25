import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class AllAnagramInString {
    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int ls = s.length();
        int lp = p.length();
        if (lp > ls) return result;

        int[] hashP = new int[26];
        int[] hashS = new int[26];

        for (char c :
                p.toCharArray()) {
            hashP[c - 'a']++;
        }

        for (int i = 0; i < ls; i++) {
            int index = s.charAt(i) - 'a';
            hashS[index]++;

            if (i >= lp) {
                int in = s.charAt(i - lp) - 'a';
                hashS[in]--;
            }

            if (Arrays.equals(hashP, hashS)) {
                result.add(i - lp + 1);
            }
        }
        return result;
    }

    static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (p.length() > s.length()) {
            return list;
        }

        int[] hash = new int[26];
        Arrays.fill(hash, 0);

        for (char c : p.toCharArray()) {
            int index = c - 'a';
            hash[index]++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (hash[index] != 0) {
                int[] h = Arrays.copyOf(hash, hash.length);
                if (isAnagram(s, i, p.length(), h)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    static boolean isAnagram(String s, int start, int end, int[] hash) {
        for (int i = start; i < start + end; i++) {
            int index = s.charAt(i) - 'a';
            hash[index]--;
            if (hash[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
