package codechef;

import java.util.Scanner;

public class ChefAndIceCream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int five = 0;
            int ten = 0;
            int n = sc.nextInt();

            boolean ignore = false;
            for (int i = 0; i < n; i++) {

                int coin = sc.nextInt();
                if (ignore) {
                    continue;
                }

                if (coin == 5) five++;
                else if (coin == 10) {
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        ignore = true;
                    }
                } else {
                    if (ten > 0) {
                        ten--;
                    } else if (five > 1) {
                        five -= 2;
                    } else {
                        ignore = true;
                    }
                }
            }

            if(ignore) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        sc.close();
    }
}
