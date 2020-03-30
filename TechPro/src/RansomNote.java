/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[128];
        for (char c :
                magazine.toCharArray()) {
            hash[c]++;
        }

        for (char c :
                ransomNote.toCharArray()) {
            hash[c]--;
            if (hash[c] < 0) return false;
        }

        return true;
    }
}
