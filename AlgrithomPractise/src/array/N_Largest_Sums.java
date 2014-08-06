package array;

import commonDataStructures.Heap;

/**
 * Given two sorted positive integer arrays A(n) and B(n) , we define a set S =
 * {(a,b) | a inA and b in B}. Obviously there are n^2 elements in S. The value
 * of such a pair is defined as Val(a,b) = a + b. Now we want to get the n pairs
 * from S with largest values. The tricky part is that we need an O(n)
 * algorithm.
 * 
 * I don't think O(n) solution exist. The best solution solition I can think of
 * is using heap. The solution is O(n(log(log(n))))
 * 
 * @author shen
 * 
 */
//public class N_Largest_Sums {
//	public static int nLargestSums(int a[], int b[]) {
//		int m = a.length;
//		int n = b.length;
//		int i = m;
//		int j = n;
//		Heap heap = new Heap();
//		// heap.put(a);
//		while (i > 0 && j > 0) {
//			
//		}
//	}
// }
