package qualityQuestions;

import java.util.Arrays;

public class LongestSubStringWithoutRepeatation {

    public static void main(String[] args) {
        String s = "tmmzuxt";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {

        int[] map = new int[256];
        Arrays.fill(map, -1);

        int length = s.length();
        int cur_length = 0;
        int max_length = 0;
        int prev_index;
        for (int end = 0; end < length; end++) {

            prev_index = map[s.charAt(end)];
            if (prev_index == -1 || (end - cur_length > prev_index)) {
                cur_length++;
            } else {
                max_length = Math.max(max_length, cur_length);

                cur_length = end - prev_index;
            }

            map[s.charAt(end)] = end;
        }

        max_length = Math.max(max_length, cur_length);
        return max_length;
    }

    /* repetition */

    int longestSubStringLengthWithOutRepetition(String str) {

        int maxLength = 1;
        int currentLength = 1;
        int[] hash = new int[256];
        hash[str.charAt(0)] = 0;

        int prevIndex = -1;
        for (int index = 1; index < str.length(); index++) {

            if (prevIndex == -1 || ((currentLength - index) > prevIndex)) {
                currentLength++;
            } else {

                Math.max(maxLength, currentLength);
                currentLength = index - prevIndex;
            }

            hash[str.charAt(index)] = index;
        }

        return Math.max(maxLength, currentLength);
    }
}


