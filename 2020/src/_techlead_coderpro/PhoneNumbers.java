package _techlead_coderpro;


import java.util.ArrayList;
import java.util.List;

public class PhoneNumbers {
    private static final String[] map =
            {"", "", "abc", "def", "hij", "klm", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String number = "324";
        List<String> words = new ArrayList<>();

        makeWord(number, 0, "", words);
        System.out.println(words.toString());
    }

    private static void makeWord(String number, int index, String word, List<String> words) {
        if (index == number.length()) {
            words.add(word);
            return;
        }

        int key = number.charAt(index) - '0';
        String str = map[key];
        for (char c : str.toCharArray()) {
            makeWord(number, index + 1, word + c, words);
        }
    }
}
