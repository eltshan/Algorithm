package array;

/**
 * Manacher alg
 * O(n) time for finding all pailndrome
 * 
 * @author shen
 * 
 */
public class Find_Palandrom {
	public static int findLongestPalandrom(char array[]) {
		int n = array.length;
		int length = n * 2 + 1;
		char A[] = new char[length];
		int p[] = new int[length];
		int currentMax = 1;
		// initialize aux array
		for (int i = 0; i < length; i++) {
			if (i % 2 != 0)
				A[i] = array[i / 2];
			else
				A[i] = '#';
		}

		int mx = 0; // farest position reached
		int id = 0; // id for corresponding center
		p[0] = 1;
		for (int i = 1; i < A.length; i++) {
			// if current element is within the range of farest reached position
			if (mx > i) {
				// p[2*id-1] is the symmertric element
				// (mx = p[id] + id), mx - i is the farest center
				p[i] = Math.min(p[2 * id - i], mx - i);
				if (p[i] > currentMax)
					currentMax = p[i];
			} else
				p[i] = 1;
			for (; (i - p[i] >= 0 && i + p[i] < length)
					&& A[i + p[i]] == A[i - p[i]]; p[i]++)
				;
			if (p[i] + i > mx) {
				mx = p[i] + i;
				id = i;
			}
		}

		// output
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < A.length; i++) {
			sb1.append(A[i] + "\t");
			sb2.append((p[i] - 1) + "\t");
		}

		System.out.println(sb1.toString());
		System.out.println(sb2.toString());

		return currentMax;
	}

	public static void main(String args[]) {
		findLongestPalandrom(new char[] { 'a', 'b', 'a' });
		// System.out
		// .println(findLongestPalandrom(new int[] { 1, 2, 3, 4, 3, 2, 0 }));
	}
}
