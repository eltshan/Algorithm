package array;

/**
 * Given an array A of positive integers. Convert it to a sorted array with
 * minimum cost. The only valid operation are: 1) Decrement with cost = 1 2)
 * Delete an element completely from the array with cost = value of element
 * 
 * @author shen
 * 
 */
public class Convert_Array_To_Sorted_Array_Min_Cost {
	public static int convertToSortedArrayMinCost(int[] A) {
		int n = A.length;
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (A[i] > max)
				max = A[i];
			if (A[i] < min)
				min = A[i];
		}
		int m = max - min;
		int[][] DP = new int[n][m + 1];
		for (int j = 0; j <= m; j++) {
			DP[0][j] = Math.max((A[0] - min) - j, 0);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= m; j++) {
				int tmp = A[i] - min;
				// if (j - tmp >= 0)
				// // cost
				// DP[i][j] = DP[i - 1][j] + Math.min(tmp, j - tmp);
				// else
				// // cost A[i]
				// DP[i][j] = DP[i - 1][j] + tmp;
				if (tmp >= j)
					DP[i][j] = DP[i - 1][j] + tmp - j;
				else {
					DP[i][j] = DP[i - 1][j] + tmp;
				}
			}
		}

		int result = Integer.MAX_VALUE;
		for (int j = 0; j <= m; j++) {
			if (DP[n - 1][j] < result) {
				result = DP[n - 1][j];
			}
		}

		return result + min;
	}

	public static void main(String[] args) {
		System.out
				.println(convertToSortedArrayMinCost(new int[] { 11,10, 3, 12 }));
	}
}
