package _techlead_coderpro;

import java.util.HashMap;
import java.util.Map;

public class CharacterMapping87 {
    public static void main(String[] args) {
        System.out.println(hasCharacterMapping("abc","def"));
        System.out.println(hasCharacterMapping("aac","def"));
    }

    static boolean hasCharacterMapping(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char x = s1.charAt(i);
            char y = s2.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else {
                if (map.get(x) != y) {
                    return false;
                }
            }
        }

        return true;
    }
}
