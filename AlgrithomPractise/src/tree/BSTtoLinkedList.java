package tree;

import java.util.Stack;

import commonDataStructures.TreeNode;

public class BSTtoLinkedList {

	public static TreeNode DLinkListToBST(TreeNode head) {
		int i = 0;
		TreeNode p = head;
		TreeNode mid = head;
		while (p != null) {
			p = p.right;
			if ((++i) % 2 == 0)
				mid = mid.right;
		}

		// System.out.println(mid.val + " " + i);
		mid.left = DL2BSTHelper(head, 0, i / 2 - 1);
		// System.out.println(mid.left.val);

		mid.right = DL2BSTHelper(mid.right, i / 2 + 1, i - 1);
		// System.out.println(mid.right.val);

		return mid;

	}

	private static TreeNode DL2BSTHelper(TreeNode T, int lo, int hi) {
		if (hi < lo)
			return null;
		TreeNode result = T;
		int mid = (lo + hi) / 2;
		for (int i = lo; i < mid; i++)
			result = result.right;
		result.left = DL2BSTHelper(T, lo, mid - 1);
		result.right = DL2BSTHelper(result.right, mid + 1, hi);

		return result;

	}

	public static TreeNode bSTtoLinkedList(TreeNode root) {
		TreeNode head = new TreeNode(-1);
		B2LHelper(root, head);
		return head;
	}

	/**
	 * Not finished!
	 * 
	 * @param T
	 * @param last
	 * @return
	 */
	private static TreeNode B2LHelper(TreeNode T, TreeNode last) {
		if (T == null)
			return null;
		// System.out.println("in " + T.val + " last is " + last.val);
		last = B2LHelper(T.left, last);
		System.out.println("attach " + T.val + " to " + last.val);
		last.right = T;
		T.left = last;
		// System.out
		// .println("last " + last.val + " has been changed to " + T.val);
		last = T;

		return B2LHelper(T.right, last);

		// return T;
	}

	/**
	 * Iterative inorder travel
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode B2LIterative(TreeNode root) {
		// inorder search
		if (root == null)
			return null;
		TreeNode current;
		TreeNode head = new TreeNode(-1);
		TreeNode last = head;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {

			while (stack.peek().left != null)
				stack.push(stack.peek().left);
			// visit current
			current = stack.pop();
			last.right = current;
			current.left = last;
			last = last.right;
			while (current.right == null && !stack.isEmpty()) {
				// visit current
				current = stack.pop();
				last.right = current;
				current.left = last;
				last = last.right;
			}

			if (current.right != null)
				stack.push(current.right);

		}

		return head.right;
	}

	// public static void Test1(TreeNode[] T) {
	// System.out.println(T[0].val);
	// Test2(T);
	// System.out.println(T[0].val);
	//
	// }
	//
	// public static void Test2(TreeNode[] T) {
	// T[0] = new TreeNode(-3);
	// System.out.println(T[0].val);
	// }

	public static void main(String args[]) {
		// TreeNode x[] = { new TreeNode(1) };
		// Test1(x);
		TreeNode T = TreeNode.generateBinaryTree(new int[] { 1, 2, 3, 4, 5, 6,
				7, 8, 9, 10 });
		TreeNode head = B2LIterative(T);
		TreeNode root = DLinkListToBST(head);
		TreeNode.inOrderTravel(root);
		// while (head != null) {
		// System.out.println(head.val);
		// head = head.right;
		// }
	}
}
