
public class ConvertArrayToSortedArray {
	int[] array = new int[] { 6, 3, 2, 5, 0, 4, 1 };

	/*
	 * Convert current array to sorted array
	 */

	static public void convertToSorted(int[] array) {
		int[][] OPT = new int[array.length][2];
		for (int[] tmp : OPT) {
			for (int i = 0; i < tmp.length; i++) {
				tmp[i] = 0;
			}
		}

		OPT[0][0] = array[1];
		OPT[0][1] = array[1];
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				
			}
		}
	}
}
