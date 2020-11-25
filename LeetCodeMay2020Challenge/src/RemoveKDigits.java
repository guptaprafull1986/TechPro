import java.util.Arrays;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

    static public String removeKdigits(String num, int k) {

        int n = num.length();
        if (n == k) return "0";

        char[] sb = num.toCharArray();
        boolean[] visit = new boolean[n];
        Arrays.fill(visit, false);

        for (int x = 0; x < k; x++) {
            int i = 0;
            while (i < n - 1 && (visit[i] || sb[i] <= sb[i + 1])) {
                i++;
            }
            visit[i] = true;
        }

        char[] result = new char[n - k];
        int i = 0;
        int index = 0;
        while (i < n) {
            if (!visit[i]) {
                result[index++] = sb[i];
            }
            i++;
        }

        i = 0;
        while (result[i] == '0') {
            i++;
        }
        String s = "";

        while (i < n) {
            s += result[i++];
        }
        if (s.length() == 0) return "0";

        return s;
    }

    static public String removeKdigits1(String num, int k) {

        int n = num.length();
        if (n == k) return "0";

        StringBuilder sb = new StringBuilder(num);

        for (int x = 0; x < k; x++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }

        if (sb.length() == 0) return "0";

        return sb.toString();
    }
}
