package airthmaticoperation;

public class Addition {

	public static void main(String[] args) {

		String num2 = "12354345";
		String num1 = "657";

		int[] sum = sum(num1, num2);

		int result = 0;
		for (int i = 0; i < sum.length; i++) {
			result = result * 10 + sum[i];
		}

		System.out.println("result : " + result);
	}

	public static int[] sum(String num1, String num2) {

		if (num2.length() > num1.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}

		int n1 = num1.length();
		int n2 = num2.length();

		int carry = 0;
		int[] sum = new int[n1 + 1];

		int i = n1 - 1;
		int j = n2 - 1;
		while (j >= 0) {
			int x = num1.charAt(i) - '0';
			int y = num2.charAt(j) - '0';
			int s = x + y + carry;

			carry = s / 10;
			sum[i + 1] = s % 10;

			j--;
			i--;
		}

		while (i >= 0) {
			int s = num1.charAt(i) - '0' + carry;
			carry = s / 10;
			sum[i + 1] = s % 10;
			i--;
		}
		sum[0] = carry;
		return sum;
	}

}
