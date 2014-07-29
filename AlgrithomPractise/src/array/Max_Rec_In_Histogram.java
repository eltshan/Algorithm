package array;

import java.util.Stack;

/**
 * How to find the maximum rectangular in a histogram?
 * 
 * O(n) solution
 * 
 * @author shen
 * 
 */
public class Max_Rec_In_Histogram {
	public static int maxRecInHistogram(int A[]) {
		assert (A != null);
		Stack<Integer> stack = new Stack<>();
		int Max = 0;
		stack.push(0);
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= A[stack.peek()])
				stack.push(i);
			else {
				int currentMax = 0;
				while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
					currentMax = (i + 1 - stack.peek()) * A[stack.peek()];
					stack.pop();
					Max = Math.max(currentMax, Max);
				}

				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			int currentMax = A[stack.peek()] * (A.length - stack.peek());
			Max = Math.max(currentMax, Max);
			stack.pop();
		}

		return Max;
	}

	public static void main(String args[]) {

		System.out
				.println(maxRecInHistogram(new int[] { 6, 2, 5, 4, 5, 1, 6 }));
	}
}
