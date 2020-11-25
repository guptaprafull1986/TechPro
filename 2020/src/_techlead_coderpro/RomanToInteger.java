package _techlead_coderpro;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('M', 1000);

        System.out.println(romanToInt("MCMIV", map));
    }

    private static int romanToInt(String str, Map<Character, Integer> map) {
        int sum = 0;
        int prev = 0;
        int curr;
        for (int i = str.length() - 1; i >= 0; i--) {
            curr = map.get(str.charAt(i));
            if (prev > curr) {
                sum -= curr;
            } else {
                sum += curr;
            }
            prev = curr;
        }
        return sum;
    }
}
