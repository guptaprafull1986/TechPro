package qualityQuestions;

import java.util.Arrays;

/**
 * Also called "Length of the longest substring without repeating characters"
 * Given a string str, find the length of the longest substring without repeating characters.
 * <p>
 * For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
 * For “BBBB” the longest substring is “B”, with length 1.
 * For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7
 */
public class StringReduction {
    private static final int LENGTH = 256;

    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("ABDEFABEFG"));
    }

    static int longestUniqueSubstring(String str) {

        // null or empty > return 0

        int[] map = new int[LENGTH];
        Arrays.fill(map, -1);
        map[str.charAt(0)] = 0;
        int n = str.length();

        int prev_index;
        int curr_length = 1;
        int max_length = 1;

        for (int i = 1; i < n; i++) {
            int index = str.charAt(i);
            prev_index = map[index];

            if (prev_index == -1 || (i - curr_length) > prev_index) {
                //abcbdeac a is not the part of cbde
                curr_length++;

            } else {

                if (curr_length > max_length) {
                    max_length = curr_length;
                }
                curr_length = i - prev_index;
            }

            map[index] = i;
        }

        if (curr_length > max_length) {
            max_length = curr_length;
        }

        return n - max_length;
    }
}

/**
 *    64  32 16 8 4 2 1
 * char x = 'C'; 67 1000011
 * char y = 'c'; 99 1100011
 * Fail
 *
 * if(x == y || (x ^ 32) == y)
 *
 *
 */