package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Three_Sum_Close {
	public static int threeSumClosest(int[] num, int target) {
		// n^2logn
		int n = num.length;
		int currentOffset = Integer.MAX_VALUE;
		int tmp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 2; j < n; j++) {
				tmp = (num[i] + num[j] + num[binarySearch(num, i + 1, j - 1,
						target - num[i] - num[j])]);
				if (Math.abs(currentOffset - target) > Math.abs(tmp - target))
					currentOffset = tmp;
			}
		}

		return Math.abs(currentOffset);
	}

	private static int binarySearch(int[] A, int lo, int hi, int target) {
		if (lo >= hi)
			return hi;
		int mid = (lo + hi) / 2;
		if (A[mid] == target)
			return mid;
		if (A[mid] > target) {
			if (mid == lo)
				return lo;
			else if (A[mid - 1] < target)
				return A[mid] - target > target - A[mid - 1] ? mid - 1 : mid;
		}
		if (A[mid] < target) {
			if (mid == hi)
				return hi;
			else if (A[mid + 1] > target)
				return target - A[mid] > A[mid + 1] - target ? mid : mid + 1;
		}
		if (A[mid] > target) {
			return binarySearch(A, lo, mid - 1, target);
		} else
			return binarySearch(A, mid + 1, hi, target);
	}

	public static void main(String args[]) {
		int num[] = new int[] { 1, 1, -1, -1, 3 };
		System.out.println(threeSumClosest(num, -1));
	}
}
