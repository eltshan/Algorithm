package commonDataStructures;

/**
 * Binary Search Tree
 * 
 * @author shen
 * 
 */
public class BST extends TreeNode {

	public BST() {
		
	}

	public TreeNode search(int target) {
		return searchHelper(root, target);
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
}
