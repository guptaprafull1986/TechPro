package google;

public class AddTwoBinaryStrings {
    public static void main(String[] args) {
        System.out.println(addTwoBinaryNumber("101", "010"));
        System.out.println(addTwoBinaryNumber("111", "1"));
    }

    static String addTwoBinaryNumber(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return s2;
        if (s2 == null || s2.length() == 0) return s1;
        int m = s1.length();
        int n = s2.length();

        int carry = 0;

        int i = m - 1;
        int j = n - 1;
        String result = "";
        while (i >= 0 || j >= 0 || carry == 1) {
            int x = i >= 0 ? s1.charAt(i) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            result = (sum & 1) + result;
            carry = sum >> 1;
//            result = sum % 2 + result;
//            carry = sum / 2;
            i--;
            j--;
        }
        return result;
    }

    public String addNumbers(String s1, String s2) {

        if (s1 == null || s1.length() == 0) return s2;
        if (s2 == null || s2.length() == 0) return s1;

        int m = s1.length();
        int n = s2.length();
        int carry = 0;
        int i = m - 1;
        int j = n - 1;
        String result = "";
        while (i >= 0 || j >= 0 || carry == 1) {

            int x = i >= 0 ? s1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            result = (sum % 10) + result;
            carry = sum / 10;
        }

        return result;
    }
}

