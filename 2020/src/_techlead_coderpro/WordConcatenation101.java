package _techlead_coderpro;

import java.util.*;

public class WordConcatenation101 {

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "dog", "catsdog"};
        List<String> list = findAllConcatenatedWords(words);
        for (String word : list) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    private static List<String> findAllConcatenatedWords(String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(s);
        }
        Map<String, Boolean> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String s : words) {
            if (canForm(s, set, map)) {
                list.add(s);
            }
        }
        return list;
    }

    private static boolean canForm(String word, Set<String> set, Map<String, Boolean> map) {
        if (map.containsKey(word)) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, word.length());
            if (set.contains(prefix)) {
                if (set.contains(suffix) || canForm(suffix, set, map)) {
                    map.put(word, true);
                    return true;
                }
            }
        }
        map.put(word, false);
        return false;
    }
}
