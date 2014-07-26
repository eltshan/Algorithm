import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import commonDataStructures.TreeNode;

public class PlayWithTree {

	public TreeNode buildBST(int[] list) {
		Arrays.sort(list);
		// Collections.sort(list);
		return buildBSTHelper(list, 0, list.length - 1);
	}

	private TreeNode buildBSTHelper(int[] list, int lo, int hi) {
		if (lo > hi)
			return null;
		int mid = (lo + hi) / 2;
		TreeNode T = new TreeNode(list[mid]);
		T.left = buildBSTHelper(list, lo, mid - 1);
		T.right = buildBSTHelper(list, mid + 1, hi);
		return T;
	}

	public TreeNode removeDuplicateFromBST(TreeNode root) {
		return null;
	}

	/**
	 * Remove duplicate from BST
	 * 
	 * @param T
	 * @param father
	 * @param lastVisited
	 * @param toBeDeleted
	 * @param toBeDeletedFather
	 */
	private void removeDuplicateFromBSTHelper(TreeNode T, TreeNode father,
			TreeNode lastVisited, TreeNode toBeDeleted,
			TreeNode toBeDeletedFather) {

		if (T == null)
			return;
		removeDuplicateFromBSTHelper(T.left, T, lastVisited, toBeDeleted,
				toBeDeletedFather);
		System.out.println(T.val);
		if (toBeDeleted != null) {
			remove(toBeDeleted, toBeDeletedFather, T, father);
			toBeDeleted = null;
		}
		if (lastVisited != null && T.val == lastVisited.val) {
			if (T.left == null && T.right == null) {
				T = null;
			} else {
				toBeDeletedFather = father;
				toBeDeleted = T;
			}
		} else {
			lastVisited = T;
		}
		if (T != null)
			removeDuplicateFromBSTHelper(T.right, T, lastVisited, toBeDeleted,
					toBeDeletedFather);

	}

	private void remove(TreeNode toBeDeleted, TreeNode toBeDeletedFather,
			TreeNode T, TreeNode father) {
		if (toBeDeleted == toBeDeletedFather.left)

			toBeDeletedFather.left = T;
		else if (toBeDeleted == toBeDeletedFather.right)
			toBeDeletedFather.right = T;
		father.left = T.right;
		T.left = toBeDeleted.left;
		T.right = toBeDeleted.left;
	}

	public void inOrderTravel(TreeNode root) {
		inorderTravelHelper(root);
	}

	private void inorderTravelHelper(TreeNode T) {
		if (T == null)
			return;
		inorderTravelHelper(T.left);
		System.out.println(T.val + " ");
		inorderTravelHelper(T.right);
		return;
	}

	/**
	 * Travel through a tree iteratively
	 * 
	 * @param root
	 * @return
	 */

	private ArrayList<TreeNode> inorderTravelIterative(TreeNode root) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode current;

		while (!stack.isEmpty()) {

			// find the left most element
			while (stack.peek().left != null) {
				stack.push(stack.peek().left);
			}

			// print the left most element
			current = stack.pop();
			System.out.println(current.val);
			result.add(current);

			// find the first element that has a right child
			// if current element has no child, then this element should be
			// visited
			while (current.right == null && !stack.isEmpty()) {
				current = stack.pop();
				System.out.println(current.val);
				result.add(current);
			}

			// put the right child into stack
			if (current.right != null) {
				stack.push(current.right);
			}
		}
		return result;
	}

	public void testRemoveDuplicateFromBST() {
		int[] test = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 9, 9, 7, 2, 12, 15 };
		TreeNode T = buildBST(test);
		removeDuplicateFromBSTHelper(T, null, null, null, null);
		inOrderTravel(T);

	}

	static public void main(String args[]) {
		PlayWithTree pwt = new PlayWithTree();
		int[] test = { 1, 2, 3, 4, 5, 6, 7 };

		TreeNode T = pwt.buildBST(test);
		System.out.println(pwt.inorderTravelIterative(T));

		// pwt.testRemoveDuplicateFromBST();

	}

}
