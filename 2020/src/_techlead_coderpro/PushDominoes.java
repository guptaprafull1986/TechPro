package _techlead_coderpro;

public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(pushDominoes("..R...L..R."));
    }

    static String pushDominoes(String str) {
        int[] force = new int[str.length()];
        int maxForce = str.length();
        int f = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'R') {
                f = maxForce;
            } else if (c == 'L') {
                f = 0;
            } else {
                f = Math.max(0, f - 1);
            }
            force[i] = f;
        }

        f = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == 'L') {
                f = maxForce;
            } else if (c == 'R') {
                f = 0;
            } else {
                f = Math.max(0, f - 1);
            }
            force[i] -= f;
        }

        String s = "";
        for (int n : force) {
            if (n == 0) {
                s += ".";
            } else if (n > 0) {
                s += "R";
            } else {
                s += "L";
            }
        }
        return s;
    }
}
