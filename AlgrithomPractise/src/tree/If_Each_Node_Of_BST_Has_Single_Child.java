package tree;

/**
 * Given a sequence of int, without building BST, determine if each node of BST
 * has single child
 * 
 * actually this has nothing to do with tree
 * 
 * @author shen
 * 
 */
public class If_Each_Node_Of_BST_Has_Single_Child {

	public static boolean hasSingleChild(int[] array) {
		if (array == null)
			return true;
		int n = array.length;
		if (n <= 1)
			return true;
		int currentMax = array[n - 1];
		int currentMin = array[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (array[i] >= currentMax) {
				currentMax = array[i];
				continue;
			} else if (array[i] <= currentMin) {
				currentMin = array[i];
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out
				.println(hasSingleChild(new int[] { 10, 19, 17, 14, 15, 16 }));
	}
}
