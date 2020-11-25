package _slidingwindow;

public class LongestRepeatingCharacterReplacementAPlus {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }

    static int characterReplacement(String str, int k) {
        if (str == null || str.isEmpty()) return 0;
        int[] map = new int[26];
        int maxLength = 0;
        int maxCount = 0;
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            int endIndex = str.charAt(end) - 'A';
            map[endIndex]++;
            maxCount = max(maxCount, map[endIndex]);

            if (end - start + 1 - maxCount > k) {
                int startIndex = str.charAt(start) - 'A';
                map[startIndex]--;
                start++;
            }
            maxLength = max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    static int max(int x, int y) {
        return x > y ? x : y;
    }
}
