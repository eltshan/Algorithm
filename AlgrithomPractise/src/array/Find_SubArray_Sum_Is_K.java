package array;

import java.util.HashMap;

/**
 * Given unsorted array with positive and negative emlements, find the
 * consective subarray whose sum is K
 * 
 * small but exists
 * 
 * @author shen
 * 
 */
public class Find_SubArray_Sum_Is_K {

	public static int[] findSubArraySumIsK(int[] A, int k) {
		int result[] = new int[2];
		int n = A.length;
		int preSum[] = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		preSum[0] = A[0];
		for (int i = 1; i < n; i++) {
			preSum[i] = preSum[i - 1] + A[i];
			if (map.keySet().contains(preSum[i] - k)) {
				result[0] = map.get(preSum[i] - k);
				result[1] = i;
				return result;
			}
			map.put(preSum[i], i);

		}

		return null;
	}

	public static void main(String args[]) {
		int array[] = new int[] { 6, 3, 2, 5, 0, 4, 1 };
		// 6, 9, 11, 16, 16, 20, 21
		int result[] = findSubArraySumIsK(array, 10);
		System.out.println(result[0] + " " + result[1]);
	}
}
