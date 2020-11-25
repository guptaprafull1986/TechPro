package _leetcodegoogle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class LengthOfLongestSubstringTwoDistinct {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aabbccc"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aabbccc"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() < 3) return s.length();

        int max = 2;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap();

        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, right++);

            if (map.size() == 3) {
                // to find the element which is on the left most side to remove from string
                int minIndex = Collections.min(map.values());
                map.remove(s.charAt(minIndex));
                left = minIndex + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            char key = str.charAt(right);
            map.put(key, right);
            if (map.size() > k) {
                int minIndex = Collections.min(map.values());
                map.remove(str.charAt(minIndex));
                left = minIndex + 1;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
