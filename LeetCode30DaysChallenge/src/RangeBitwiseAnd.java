public class RangeBitwiseAnd {
    public static void main(String[] args) {

        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }

    public static int rangeBitwiseAnd(int m, int n) {

        int ans = 2147483647;
        int i = m;
        while (i >= 0 && i <= n) {
            if (mulZero(i, n)) {
                return 0;
            }
            ans = ans & i;

            if (ans == 0) return 0;

            if (mulZero(ans, n)) {
                return 0;
            }
            i++;
        }

        return ans;
    }

    private static boolean mulZero(int num, int n) {
        if ((num & (num - 1)) == 0) {
            int x = num << 1;
            if (x <= n) {
                return true;
            }
        }
        return false;
    }
}
