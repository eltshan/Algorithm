package tree;

import java.util.Arrays;

import commonDataStructures.TreeNode;

/**
 * Build BST from preorder not tested
 * 
 * @author shen
 * 
 */
public class Build_BST_From_Preorder {

	public static TreeNode buildBSTFromPreOrder(int[] array) {

		assert (array != null && array.length > 0);
		// now aux is in order
		int aux[] = array.clone();
		Arrays.sort(aux);

		return buildBSTHelper(array, 0, aux.length - 1, aux, new int[] { 0 });
	}

	private static int binarySearch(int[] array, int target) {
		return binarySearchHelper(array, target, 0, array.length - 1);
	}

	private static int binarySearchHelper(int[] A, int target, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = (lo + hi) / 2;
		if (A[mid] == target)
			return mid;
		if (A[mid] < target)
			return binarySearchHelper(A, target, lo, mid - 1);
		else
			return binarySearchHelper(A, target, mid + 1, hi);
	}

	private static TreeNode buildBSTHelper(int[] preOrder, int il, int ih,
			int[] inOrder, int[] index) {
		// if (index >= preOrder.length)
		// return null;
		if (il > ih)
			return null;

		TreeNode T = new TreeNode(preOrder[index[0]]);
		int split = binarySearchHelper(inOrder, preOrder[index[0]++], il, ih);
		T.left = buildBSTHelper(preOrder, il, split - 1, inOrder, index);
		T.right = buildBSTHelper(preOrder, split + 1, ih, inOrder, index);
		return T;
	}

	public static void main(String[] args) {

	}
}
