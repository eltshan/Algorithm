package tree;

import commonDataStructures.TreeNode;

public class Find_Least_Common_Ancestors_without_parentNode {

	public static TreeNode leastCommonAncestor(TreeNode T, TreeNode T1,
			TreeNode T2) {

		if (T == null)
			return null;

		if (T == T1 || T == T2)
			return T;

		TreeNode Tleft;
		TreeNode Tright;
		Tleft = leastCommonAncestor(T.left, T1, T2);
		Tright = leastCommonAncestor(T.right, T1, T2);
		if (Tleft != null && Tright != null)
			return T;
		if (Tleft != null)
			return Tleft;
		return Tright;

	}

	public static void main(String[] args) {
		int testArray[] = { 6, 3, 2, 5, 0, 4, 1 };

		TreeNode root = TreeNode.generateBinaryTree(testArray);

		// TreeNode.inOrderTravel(root);
		// for (TreeNode t : TreeNode.inorderTravelIterative(root)) {
		// System.out.println(t.val);
		// }
		TreeNode T1 = root.right.left;
		TreeNode T2 = root.right;

		TreeNode xNode = leastCommonAncestor(root, T1, T2);
		System.out.println(xNode.val);
	}
}
