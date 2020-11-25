package _dynamicprogramming.palindromicsubsequence;

public class CountPalindromicSubStrings {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubStrings("abcb"));
    }

    private static int countPalindromicSubStrings(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        return rec(str, 0, str.length() - 1);
    }

    private static int rec(String str, int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        if (str.charAt(start) == str.charAt(end)) {
            //if()
        } else {
            return rec(str, start + 1, end) + rec(str, start, end - 1);
        }
        return 0;
    }
}
