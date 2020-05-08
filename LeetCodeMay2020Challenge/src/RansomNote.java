import java.util.Arrays;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true
 * if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * You may assume that both strings contain only lowercase letters.
 */
public class RansomNote {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length();
        int n = magazine.length();
        if (m > n) return false;

        int[] map = new int[256];
        Arrays.fill(map, 0);
        for (int i = 0; i < n; i++) {
            int index = magazine.charAt(i);
            map[index]++;
        }

        for (int i = 0; i < m; i++) {
            int index = ransomNote.charAt(i);
            if (map[index] == 0) {
                return false;
            }
            map[index]--;
        }
        return true;
    }
}
