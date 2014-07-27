package commonDataStructures;

/**
 * Binary Search Tree
 * 
 * @author shen
 * 
 */
public class BST {

	TreeNode root;

	public BST(TreeNode T) {
		root = T;
	}

	/**
	 * Search for given target. If target did not exist, return null;
	 * 
	 * @param target
	 * @return
	 */
	public TreeNode search(int target) {
		return searchHelper(this.root, target);
	}

	private TreeNode searchHelper(TreeNode T, int target) {
		if (T == null)
			return null;
		if (T.val == target)
			return T;
		if (T.val < target)
			return searchHelper(T.right, target);
		else {
			return searchHelper(T.left, target);
		}
	}

	/**
	 * Search for given taret, if target did not exist, return the largest
	 * element which is smaller that target.
	 * 
	 * 
	 * @param target
	 * @return
	 */
	public TreeNode search2(int target) {
		return search2Helper(this.root, target, null);
	}

	private TreeNode search2Helper(TreeNode T, int target, TreeNode previous) {
		if (T == null)
			return previous;// ??
		if (T.val < target) {
			return search2Helper(T.right, target, T);
		}
		if (T.val > target) {
			return search2Helper(T.left, target, previous);
		}
		return T;

	}

	public static void main(String args[]) {
		BST root = new BST(TreeNode.generateBinaryTree(new int[] { 1, 2, 3, 4,
				6, 7, 8 }));
		System.out.println(root.search2(6).val);

	}
}
