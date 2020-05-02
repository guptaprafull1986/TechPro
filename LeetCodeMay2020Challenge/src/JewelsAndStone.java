import java.util.Arrays;

/**
 * Jewels and Stones
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStone {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String J, String S) {
        boolean[] map = new boolean[256];

        Arrays.fill(map, false);
        for (int i = 0; i < J.length(); i++) {
            int index = J.charAt(i);
            map[index] = true;
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i);
            if (map[index]) {
                count++;
            }
        }

        return count;
    }
}
