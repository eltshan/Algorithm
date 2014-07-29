package array;

/**
 * Given an array A[], find all pairs such that i < j and A > A[j]
 * 
 * Strategy is Divide and Conquer
 * 
 * a lot of problems, need to do this over again
 * 
 * @author shen
 * 
 */
public class Find_Inversions {
	public static int numOfInversions(int A[]) {
		return numOfInversionsHelper(A, 0, A.length - 1,
				new int[A.length / 2 + 1]);
	}

	// merge sort at the same time
	private static int numOfInversionsHelper(int A[], int lo, int hi, int[] aux) {
		if (lo >= hi)
			return 0;

		int mid = (lo + hi) / 2;
		int left = numOfInversionsHelper(A, lo, mid, aux);
		int right = numOfInversionsHelper(A, mid + 1, hi, aux);
		// merge sort
		int midInversions = 0;
		for (int i = lo; i <= mid; i++) {
			aux[i - lo] = A[i];
		}
		int k = lo;
		int i = lo; // i from lo to mid
		int j = mid + 1;// j from mid+1 to hi
		boolean flag = true;
		while (i <= mid && j <= hi) {
			if (aux[i - lo] > A[j]) {
				if (flag) {
					midInversions += (hi - j + 1) * (mid - i + 1);
					flag = false;
				}
				A[k++] = A[j++];
			} else {
				A[k++] = aux[(i++) - lo];
			}
			if (i > mid) {
				while (j <= hi)
					A[k++] = A[j++];
			}

			if (j > hi) {
				while (i <= mid)
					A[k++] = aux[(i++) - lo];
			}
		}

		return midInversions + left + right;
	}

	public static void main(String[] args) {
		int A[] = new int[] { 6,3,0,1,-1,-2,2 };
		System.out.println(numOfInversions(A));
//		for (int x : A) {
//			System.out.println(x);
//		}
	}
}
