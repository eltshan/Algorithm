package array;

/**
 * partially tested there maybe bugs
 * 
 * @author shen
 * 
 */
public class Quick_Search {
	/**
	 * Find kth smallest element in O(n)
	 */
	public static int quickSearch(int A[], int k) {
		assert (A != null && A.length > k);
		return quickSearchHelper(A, 0, A.length - 1, k);

	}

	private static int quickSearchHelper(int[] A, int lo, int hi, int k) {
		int i = lo + 1;
		int j = hi;
		while (true) {
			while (A[i] < A[lo] && i < j)
				i++;
			while (A[j] > A[lo] && i < j)
				j--;
			if (i >= j)
				break;
			swap(A, i++, j--);
		}
		swap(A, lo, j);
		if (j == k)
			return j;
		if (j < k)
			return quickSearchHelper(A, j + 1, hi, k);
		else
			return quickSearchHelper(A, lo, j - 1, k);
	}

	private static void swap(int[] A, int a, int b) {
		A[a] ^= A[b];
		A[b] ^= A[a];
		A[a] ^= A[b];
	}

	public static void main(String args[]) {
		System.out.println(quickSearch(new int[] { 6, 3, 2, 5, 0, 4, 1 }, 3));
	}
}
