/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
    }

    public static boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                close++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                }
                close--;
            } else {    // c == '*'
                if (open > 0) {
                    open--;
                }
                close++;
            }

            if (close < 0) return false;
        }

        return open == 0;
    }
}
