package _techlead_coderpro;

public class FindPalindrome {
    public static void main(String[] args) {
        System.out.println(findPalindrome("foxfo"));
    }

    private static String findPalindrome(String str) {
        String s = "";
        int[] hash = new int[26];
        for (char c : str.toCharArray()) {
            hash[c - 'a']++;
        }

        char odd = '#';
        for (int i = 0; i < (str.length() + 1) / 2; i++) {
            char c = str.charAt(i);
            if ((hash[c - 'a'] & 1) == 0) {
                int x = 1;
                while (x <= hash[c - 'a'] / 2) {
                    s += c;
                    x++;
                }
            } else {
                if (odd != '#') {
                    return "";
                }
                odd = c;
            }
        }
        String palindrome = s;
        if (odd != '#') {
            int x = 1;
            while (x <= (hash[odd - 'a'] / 2) + 1) {
                palindrome += odd;
                x++;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            palindrome += s.charAt(i);
        }
        return palindrome;
    }
}

// abcd >> 1        4 + 1 / 2
// abcde >> 2       5 + 1 / 2