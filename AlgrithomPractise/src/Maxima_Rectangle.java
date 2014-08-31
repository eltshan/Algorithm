import java.util.Stack;

public class Maxima_Rectangle {

	static public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		if (n == 0)
			return 0;
		int matrixInt[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrixInt[i][j] = matrix[i][j] - '0';
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = m - 2; i >= 0; i--) {
				if (matrixInt[i + 1][j] > 0 && matrixInt[i][j] == 1)
					matrixInt[i][j] += matrixInt[i + 1][j];
			}
		}

		int max = 0;
		for (int i = 0; i < m; i++) {
			max = Math.max(max, largestRectangleArea(matrixInt[i]));
		}

		return max;
	}

	static private int largestRectangleArea(int[] height) {
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

	static public void main(String[] args) {
		char[][] matrix = new char[2][2];
		matrix[0][0] = '0';
		matrix[0][1] = '1';
		matrix[1][0] = '0';
		matrix[1][1] = '1';
		System.out.println(maximalRectangle(matrix));
	}
}
