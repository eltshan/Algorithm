import java.util.ArrayList;
import java.util.List;

public class Palandrom_Part {
	public static boolean partition(String s) {
		// n^2 solution

		int n = s.length();
		if (n <= 1) {
			return true;
		}

		int[] p = new int[2 * n - 1];
		int offset = 0;
		int index = 0;
		for (int i = 0; i < 2 * n - 1; i++) {
			offset = 0;
			index = i / 2;
			if (i % 2 == 0) {
				// centered as s.charAt(i/2)
				for (offset = 1; index - offset >= 0 && index + offset < n
						&& s.charAt(index - offset) == s.charAt(index + offset); offset++)
					;
				p[i] = offset;
			} else {
				for (offset = 0; index - offset >= 0
						&& index + offset + 1 < n
						&& s.charAt(index - offset) == s.charAt(index + offset
								+ 1); offset++)
					;
				p[i] = offset;
			}
		}

		// boolean flag[][] = new boolean[n][n];
		//
		// for (int i = 0; i < n; i++) {
		// flag[i][i] = true;
		// for (int j = i + 1; j < n; j++) {
		// if (isPalindrome(p, i, j))
		// flag[i][j] = true;
		// }
		// }
		List<List<String>> result = new ArrayList<>();
		partitionHelper(result, s, 0, new ArrayList<String>(), p);
		// String strs[][] = new String[][];
		for (int i = 0; i < result.size(); i++) {
			for (String str : result.get(i)) {
				System.out.println(str + " ");
			}
			System.out.println();
		}
		return true;
	}

	private static void partitionHelper(List<List<String>> result, String s,
			int i, List<String> tmp, int[] p) {
		if (i == s.length())
			result.add(new ArrayList<String>(tmp));
		else {
			for (int j = i; j < s.length(); j++) {
				if(j == s.length()-1)
					i = (i + 1)-1;
				
				if (isPalindrome(p, i, j)) {
					tmp.add(s.substring(i, j + 1));
					partitionHelper(result, s, j+1, tmp, p);
					tmp.remove(tmp.size() - 1);
				}
			}
		}
	}

	private static boolean isPalindrome(int[] P, int i, int j) {
		// centered around a slot
		if ((j - i) % 2 != 0) {
			if (P[i + j] >= (j - i + 1) / 2)
				return true;
		}
		// centered around a char
		else {
			if (P[i + j] - 1 >= (j - i) / 2)
				return true;
		}
		return false;
	}

	static public void main(String args[]) {
		partition("efe");
	}
}