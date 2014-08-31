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

	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int maxArea = height[0];

		for (int i = 1; i < height.length; i++) {
			// pop until the first element in the stack is <= current element
			while (!stack.isEmpty() && height[i] < height[stack.peek()]) {

				int tmp = stack.pop();
				if (!stack.isEmpty())
					maxArea = Math.max(height[tmp] * (i - stack.peek() - 1),
							maxArea);
				else
					maxArea = Math.max(height[tmp] * (i), maxArea);

			}
			stack.push(i);

		}

		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			if (!stack.isEmpty())
				maxArea = Math.max(height[tmp]
						* (height.length - stack.peek() - 1), maxArea);
			else
				maxArea = Math.max(height[tmp] * (height.length), maxArea);
		}
		return maxArea;
	}

	public static void main(String args[]) {

		System.out
				.println(largestRectangleArea(new int[] { 6, 2, 5, 4, 5, 1, 6 }));
	}
}
