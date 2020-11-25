package google;

import java.util.Stack;

public class LargestRectangeAreaInHistogram {

	public static void main(String[] args) {

		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}

	// The main function to find the maximum rectangular area under given
	// histogram with n bars
	static int getMaxArea(int hist[], int n) {
		Stack<Integer> s = new Stack<>();

		int max_area = 0;
		int top;
		int area_with_top;

		int i = 0;
		while (i < n) {
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);

			// If this bar is lower than top of stack, then calculate area of rectangle
			// with stack top as the smallest (or minimum height) bar. 'i' is
			// 'right index' for the top and element before top in stack is 'left index'
			else {
				top = s.pop(); // store the top index

				int m = s.isEmpty() ? i : i - s.peek() - 1;

				// Calculate the area with hist[tp] stack as smallest bar
				area_with_top = hist[top] * m;

				max_area = Math.max(max_area, area_with_top);
			}
		}

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (!s.empty()) {
			top = s.pop();
			area_with_top = hist[top] * (s.empty() ? i : i - s.peek() - 1);

			max_area = Math.max(max_area, area_with_top);
		}

		return max_area;

	}
}
