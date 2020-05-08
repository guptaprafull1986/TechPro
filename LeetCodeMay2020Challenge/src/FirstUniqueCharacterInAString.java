import java.util.Arrays;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        int[] map = new int[26];
        Arrays.fill(map, 0);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 1) {
                return i;
            }
        }
        return -1;
    }
}
