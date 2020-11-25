package airthmaticoperation;

public class Multipliction {

    public static void main(String[] args) {

        String num1 = "211818752139723588815458318391832122152008388429";
        String num2 = "2118187521397235888154583183918321221520083884298838480662480";
        System.out.println();
        multiply(num1, num2);
    }

    private static void multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        if (n1 == 0 || n2 == 0) {
            System.out.println("0");
            return;
        }

        int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {

            int a = num1.charAt(i) - '0';
            int carry = 0;

            for (int j = n2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';

                int sum = a * b + result[i + j + 1] + carry;
                carry = sum / 10;
                result[i + j + 1] = sum % 10;
            }

            result[i] = carry;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

    String mul(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "0";

        int m = s1.length();
        int n = s2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int carry = 0;
            int x = s2.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = s2.charAt(j) - '0';

                int sum = x * y + result[i + j + 1] + carry;
                carry = sum / 10;
                result[i + j + 1] = sum % 10;
            }

            result[i] = carry;
        }
        return null;
    }
}
