package airthmaticoperation;
public class Division {

	public static void main(String[] args) {

		String number = "12313413534672234";
		int divisor = 754;

		divide(number, divisor);
	}

	private static void divide(String number, int divisor) {
		String answer = "";
		int index = 0;
		int temp = number.charAt(index) - '0';
		while (temp < divisor) {
			temp = temp * 10 + (number.charAt(++index) - '0');
		}

		System.out.println("len : " + number.length());
		while (number.length() - 1 >= index) {
			int d = temp / divisor;
			answer += d;
			System.out.println("index : " + index);
			temp = (temp % divisor) * 10 + number.charAt(++index) - '0';
		}

		if (answer.length() == 0) {
			System.out.println("0");
		} else {
			System.out.println(answer);
		}

	}
}
