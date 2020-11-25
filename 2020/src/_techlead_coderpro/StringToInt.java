package _techlead_coderpro;

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(stringToInt("-105"));
        System.out.println(stringToInt("05"));
        System.out.println(stringToInt("-473432305"));
    }

    static int stringToInt(String num) {
        boolean isNeg = false;
        int start = 0;
        if (num.charAt(0) == '-') {
            isNeg = true;
            start = 1;
        }

        int sum = 0;
        for (int i = start; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            sum = sum * 10 + n;
        }

        if (isNeg) {
            sum = -sum;
        }
        return sum;
    }
}
