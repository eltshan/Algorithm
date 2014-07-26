package tree;

import java.util.Stack;

import commonDataStructures.TreeNode;

/**
 * Write a program to generate mirror of the binary tree without using recursion
 * 
 * @author shen
 * 
 */
public class Mirror_Binary_Tree {

	/**
	 * Iterative preorder search Transform current binary tree to it's mirror
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode mirrorBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode;
		TreeNode tmp;
		stack.push(root);
		while (!stack.isEmpty()) {
			// visit current node
			currentNode = stack.pop();

			tmp = currentNode.left;
			currentNode.left = currentNode.right;
			currentNode.right = tmp;

			if (currentNode.left != null)
				stack.push(currentNode.left);
			if (currentNode.right != null)
				stack.push(currentNode.right);
		}

		return root;
	}

	/**
	 * Create a new Mirrored BT Using two stacks
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode createMirrorBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		TreeNode currentNode;
		TreeNode resultRoot = new TreeNode(root.val);
		TreeNode result = null;
		TreeNode tmp;

		stack.push(root);
		stack2.push(resultRoot);
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			result = stack2.pop();

			tmp = currentNode.left;
			currentNode.left = currentNode.right;
			currentNode.right = tmp;

			if (currentNode.left != null)
				result.left = new TreeNode(currentNode.left.val);
			if (currentNode.right != null)
				result.right = new TreeNode(currentNode.right.val);

			if (currentNode.left != null) {
				stack.push(currentNode.left);
				stack2.push(result.left);
			}
			if (currentNode.right != null) {
				stack.push(currentNode.right);
				stack2.push(result.right);
			}
		}
		return resultRoot;
	}

	public static void main(String args[]) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeNode.generateBinaryTree(array);

		TreeNode.inOrderTravel(root);

		TreeNode result = createMirrorBST(root);
		TreeNode.inOrderTravel(result);

	}
}
