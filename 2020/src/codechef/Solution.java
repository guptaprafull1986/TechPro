package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int totalSum = 0;
        int sum = 0;
        for (int t = 1; t <= T; t++) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            totalSum = 0;
            sum = 0;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                totalSum += val;
                sum += (val >= k ? k : val);
            }
            System.out.println(totalSum - sum);
        }
        sc.close();
    }
}


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(r.readLine());

        for (int t = 1; t <= T; t++) {

            String[] arr = r.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            int totalSum = 0;
            int sum = 0;
            arr = r.readLine().trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(arr[i]);
                totalSum += val;
                sum += (val >= k ? k : val);
            }
            System.out.println(totalSum - sum);
        }
	}
}
