import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 */
public class PermutationInString {
    public static void main(String[] args) {

        String s = "a";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    static boolean findAnagrams(String p, String s) {
        List<Integer> result = new ArrayList<>();
        int ls = s.length();
        int lp = p.length();
        if (lp > ls) return false;

        int[] hashP = new int[26];
        int[] hashS = new int[26];

        for (char c :
                p.toCharArray()) {
            hashP[c - 'a']++;
        }

        for (int i = 0; i < ls; i++) {
            int index = s.charAt(i) - 'a';
            hashS[index]++;

            if (i >= lp) {
                int in = s.charAt(i - lp) - 'a';
                hashS[in]--;
            }

            if (Arrays.equals(hashP, hashS)) {
                return true;
            }
        }
        return false;
    }

}
