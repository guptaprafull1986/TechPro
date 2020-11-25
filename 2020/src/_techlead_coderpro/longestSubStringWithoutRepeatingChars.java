package _techlead_coderpro;

public class longestSubStringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(longestSubstringLength("abbcaasd"));
    }

    public static int longestSubstringLength(String s) {
        int[] hash = new int[256];
        int maxLength = 0;
        int start = -1;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            start = Math.max(start, hash[c]);
            maxLength = Math.max(maxLength, end - start);
            hash[c] = end;
        }

        return maxLength;
    }
}
