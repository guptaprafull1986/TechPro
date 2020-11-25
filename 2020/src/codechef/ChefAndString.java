package codechef;

import java.util.Scanner;

public class ChefAndString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String str = sc.next();

            int i = 0;
            int count = 0;
            while (i < str.length() - 1) {
                char x = str.charAt(i);
                char y = str.charAt(i + 1);
                if (x != y) {
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
