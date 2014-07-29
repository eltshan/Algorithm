package commonDataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public TreeNode parentNode;
	public int val;

	public TreeNode() {

		this(0);

	}

	public TreeNode(int i) {
		left = null;
		right = null;
		val = i;
		parentNode = null;
	}

	static public TreeNode findNodewithVal(int i) {
		return null;
	}

	static public TreeNode completeParentNodes(TreeNode root) {
		if (root == null)
			return null;
		if (root.left != null) {
			root.left.parentNode = root;
			completeParentNodes(root.left);
		}
		if (root.right != null) {
			root.right.parentNode = root;
			completeParentNodes(root.right);
		}

		return root;
	}

	static public TreeNode generateBinaryTree(int[] array) {

		Arrays.sort(array);
		return generateBinaryTreeHelper(array, 0, array.length - 1);

	}

	static private TreeNode generateBinaryTreeHelper(int[] array, int lo, int hi) {
		if (hi < lo)
			return null;
		int mid = (lo + hi) / 2;
		TreeNode result = new TreeNode(array[mid]);
		result.left = generateBinaryTreeHelper(array, lo, mid - 1);
		result.right = generateBinaryTreeHelper(array, mid + 1, hi);
		return result;
	}

	static public TreeNode generateBST() {
		int array[] = { 1, 2, 3, 4, 5 };
		return TreeNode.generateBinaryTree(array);

	}

	static public ArrayList<TreeNode> inorderTravelIterative(TreeNode root) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			while (stack.peek().left != null)
				stack.push(stack.peek().left);

			while (!stack.isEmpty() && stack.peek().right == null) {
				result.add(stack.pop());
			}

			if (!stack.isEmpty() && stack.peek().right != null) {
				result.add(stack.pop());
				stack.push(result.get(result.size() - 1).right);
			}
		}

		return result;
	}

	public static void inOrderTravel(TreeNode root) {
		inorderTravelHelper(root);
	}

	public static void preOrderTravel(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preOrderTravel(root.left);
		preOrderTravel(root.right);
	}

	public static void postOrderTravel(TreeNode root) {
		if (root == null)
			return;
		postOrderTravel(root.left);
		postOrderTravel(root.right);
		System.out.print(root.val);
	}

	private static void inorderTravelHelper(TreeNode T) {
		if (T == null)
			return;
		inorderTravelHelper(T.left);
		System.out.println(T.val + " ");
		inorderTravelHelper(T.right);
		return;
	}

	public boolean isBST() {
		int[] lastVisited = { Integer.MIN_VALUE };
		return isBSTHelper(this, lastVisited);
	}

	/**
	 * not tested
	 * 
	 * @param T
	 * @param lastVisited
	 * @return
	 */
	private boolean isBSTHelper(TreeNode T, int[] lastVisited) {
		if (T == null)
			return true;

		if (isBSTHelper(T.left, lastVisited)) {
			if (T.val >= lastVisited[0]) {
				lastVisited[0] = T.val;
				return isBSTHelper(T.right, lastVisited);
			} else
				return false;
		}
		return false;
	}

}
