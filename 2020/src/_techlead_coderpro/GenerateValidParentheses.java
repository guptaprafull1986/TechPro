package _techlead_coderpro;

import javafx.util.Pair;

public class GenerateValidParentheses {
    public static void main(String[] args) {
        generate(3, 0, 0, "");
        generate(4, 0, 0, "");
    }

    private static void generate(int n, int l, int r, String s) {
        if (l + r == 2 * n) {
            System.out.println(s);
            return;
        }
        if (l < n) {
            generate(n, l + 1, r, s + '(');
        }
        if (l > r) {
            generate(n, l, r + 1, s + ')');
        }
    }

    void check() {
        Math.floorMod(4, 5);

        Pair<Integer, Boolean> pair = new Pair<>(5, true);
        pair.getKey();
        pair.getValue();
    }
}
