package sort;

public class BucketSort {
	public static void bucketSort(int A[]) {

		int i = 0;
		int tmp = 0;
		while (i < A.length) {
//			for (int x : A) {
//				System.out.print(" " + x);
//			}
//			System.out.println();

			if(A[i]!=i){
				tmp = A[A[i]];
				A[A[i]] = A[i];
				A[i] = tmp;
			}
			else {
				i++;
			}
		}

	}

	public static void main(String[] args) {
		int a[] = new int[] { 0,1,5,4,3,2 };
		bucketSort(a);
		for (int x : a) {
			System.out.println(x);
		}
	}
}
