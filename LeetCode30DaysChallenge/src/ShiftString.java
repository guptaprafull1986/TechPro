/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 * <p>
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 * <p>
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */

public class ShiftString {
    public static void main(String[] args) {

//        String s = "wpdhhcj";
//
//        int[][] shift = {{0, 7}, {1, 7}, {1, 0}, {1, 3}, {0, 3}, {0, 6}, {1, 2}};

        String s = "xqgwkiqpif";
        int[][] shift = {{1, 4}, {0, 7}, {0, 8}, {0, 7}, {0, 6}, {1, 3}, {0, 1}, {1, 7}, {0, 5}, {0, 6}};
        System.out.println(stringShift(s, shift));
    }

    public static String stringShift(String s, int[][] shift) {
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                left += shift[i][1];
            } else {
                right += shift[i][1];
            }
        }

        if (left == right) {
            return s;
        }

        if (left > right) {
            // shift to left by (left - right)
            int diff = left - right;
            diff = diff % arr.length;
            char[] spare = new char[diff];
            for (int i = 0; i < diff; i++) {
                spare[i] = arr[i];
            }

            for (int i = 0; i < arr.length - diff; i++) {
                arr[i] = arr[i + diff];
            }

            for (int i = 0; i < diff; i++) {
                arr[arr.length - diff + i] = spare[i];
            }

        } else {
            // shift to right by (right - left)
            int diff = right - left;
            diff = diff % arr.length;
            char[] spare = new char[diff];
            int j = 0;
            for (int i = arr.length - diff; i < arr.length; i++) {
                spare[j++] = arr[i];
            }

            for (int i = arr.length - diff - 1; i >= 0; i--) {
                arr[i + diff] = arr[i];
            }

            for (int i = 0; i < diff; i++) {
                arr[i] = spare[i];
            }
        }

        return new String(arr);
    }
}
