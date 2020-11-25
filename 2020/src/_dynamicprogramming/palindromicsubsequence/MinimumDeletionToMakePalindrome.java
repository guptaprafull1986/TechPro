package _dynamicprogramming.palindromicsubsequence;

public class MinimumDeletionToMakePalindrome {
    public static void main(String[] args) {
        System.out.println(minDeletePalindrome("dbabad"));
        System.out.println(minDeletePalindrome("bad"));
    }

    private static int minDeletePalindrome(String str) {
        return rec(str, 0, str.length() - 1);
    }

    private static int rec(String str, int start, int end) {
        if (start >= end) return 0;

        int count1 = Integer.MAX_VALUE;
        if (str.charAt(start) == str.charAt(end)) {
            count1 = rec(str, start + 1, end - 1);
        }
        int count2 = 1 + Math.min(rec(str, start + 1, end),
                rec(str, start, end - 1));
        return Math.min(count1, count2);
    }
}
