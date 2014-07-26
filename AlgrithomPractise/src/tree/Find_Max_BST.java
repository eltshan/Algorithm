package tree;

import commonDataStructures.TreeNode;

/**
 * Given a binary tree, Find the max sub-tree that form BST
 * 
 * @author shen
 * 
 */
public class Find_Max_BST {

	public static class maxBST {
		int size;
		TreeNode treeNode;

		public maxBST(int i, TreeNode T) {
			size = i;
			treeNode = T;
		}
	}

	/**
	 * Not tested yet
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode findMaxBST(TreeNode root) {
		return findMaxBSTHelper(root).treeNode;
	}

	private static maxBST findMaxBSTHelper(TreeNode root) {
		if (root == null) {
			return new maxBST(0, root);
		}

		maxBST leftMaxBST = findMaxBSTHelper(root.left);
		maxBST rightMaxBST = findMaxBSTHelper(root.right);
		if ((leftMaxBST.treeNode == null || leftMaxBST.treeNode.val <= root.val)
				&& (rightMaxBST.treeNode == null || rightMaxBST.treeNode.val >= root.val)) {
			return new maxBST(leftMaxBST.size + rightMaxBST.size + 1, root);
		} else {
			if (leftMaxBST.size >= rightMaxBST.size)
				return leftMaxBST;
			else {
				return rightMaxBST;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.generateBST();
		TreeNode T = findMaxBST(root);
		TreeNode.inOrderTravel(root);
	}
}
