package airthmaticoperation;

public class Substration {

    public static void main(String[] args) {
        String num2 = "545";//""2343340002324";
        String num1 = "199";//""3233";

        substract(num1, num2);
    }

    private static void substract(String num1, String num2) {
        if (isSmaller(num1, num2)) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int n1 = num1.length();
        int n2 = num2.length();

        int carry = 0;
        int[] result = new int[n1];
        int i = n1 - 1;
        for (int j = n2 - 1; j >= 0; j--, i--) {
            int x = num1.charAt(i) - '0';
            int y = num2.charAt(j) - '0';
            int sub = x - y - carry;

            if (sub < 0) {
                sub += 10;
                carry = 1;
            } else {
                carry = 0;
            }

            result[i] = sub;
        }

        for (; i >= 0; i--) {
            if (num1.charAt(i) == '0' && carry == 1) {
                result[i] = 9;
                continue;
            }

            int sub = num1.charAt(i) - '0' - carry;
            result[i] = sub;
            carry = 0;
        }

        for (i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }


    String sub(String s1, String s2) {
        boolean sign = false;
        if (isSmaller(s1, s2)) {
            sign = true;
        }
        int carry = 0;
        int m = s1.length();
        int n = s2.length();
        int i = m - 1;
        int j = n - 1;
        String result = "";
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? s1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j--) - '0' : 0;
            int diff = x - y - carry;
            if (diff >= 0) {
                carry = 0;
            } else {
                carry = 1;
                diff += 10;
            }
            result = diff + result;
        }

        if (sign) {
            result = "-" + result;
        }
        return result;
    }

    private static boolean isSmaller(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return true;
        }

        if (num1.length() > num2.length()) {
            return false;
        }

        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) < num2.charAt(i)) {
                return true;
            }
            if (num1.charAt(i) > num2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

}
