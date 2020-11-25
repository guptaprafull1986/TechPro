package _techlead_coderpro;

public class AnagramsInString {
    public static void main(String[] args) {
        int[] arr = findAnagrams("acdbacdacb", "abc");
    }

    private static int[] findAnagrams(String string, String word) {
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }

        int[] currMap = new int[26];
        for (int i = 0; i < string.length() - word.length() + 1; i++) {
            int index = string.charAt(i) - 'a';
            if(i >= word.length()) {
                char c_old = string.charAt(i - word.length());

            }

        }
        return new int[0];
    }
}
