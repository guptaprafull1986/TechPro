package _dynamicprogramming.palindromicsubsequence;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abdbca"));
    }

    static int longestPalindromicSubstring(String str) {
        return longestPalindromicSubstring(str, 0, str.length() - 1);
    }

    static int longestPalindromicSubstring(String s, int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;

        if (s.charAt(start) == s.charAt(end)) {
            int remainingLength = end - start - 1;
            if (remainingLength == longestPalindromicSubstring(s, start + 1, end - 1)) {
                return 2 + remainingLength;
            }
        }
        int l1 = longestPalindromicSubstring(s, start + 1, end);
        int l2 = longestPalindromicSubstring(s, start, end - 1);

        return Math.max(l1, l2);
    }
}
