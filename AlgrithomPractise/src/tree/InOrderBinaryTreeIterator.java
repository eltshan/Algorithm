package tree;

import java.util.Stack;

import commonDataStructures.TreeNode;

public class InOrderBinaryTreeIterator {
	TreeNode root;
	Stack<TreeNode> stack;
	boolean flag;
	TreeNode buffer;

	public InOrderBinaryTreeIterator(TreeNode T) {
		root = T;
		stack = new Stack<>();
		stack.push(root);
		flag = true;
		buffer = this.getNextTreeNode();
	}

	public TreeNode peek() {
		return buffer;
	}

	public boolean hasNext() {
		if (buffer == null)
			return false;
		return true;
	}

	private boolean hasNexti() {
		return (!stack.isEmpty());
	}

	public TreeNode nextTreeNode() {
		TreeNode tmp = buffer;
		if (this.hasNexti())
			buffer = this.getNextTreeNode();
		else {
			buffer = null;
		}
		return tmp;
	}

	private TreeNode getNextTreeNode() {

		if (flag) {
			while (stack.peek().left != null)
				stack.push(stack.peek().left);
			flag = false;
			TreeNode tmp = stack.pop();
			if (tmp.right != null)
				stack.push(tmp.right);

			return tmp;
		} else {
			if (stack.peek().right == null)
				return stack.pop();
			else {
				TreeNode tmp = stack.pop();
				stack.push(tmp.right);
				flag = true;
				return tmp;
			}
		}

	}

	public static void main(String args[]) {
		TreeNode rootNode = TreeNode.generateBST();
		InOrderBinaryTreeIterator iterator = new InOrderBinaryTreeIterator(
				rootNode);
		while (iterator.hasNext()) {
			System.out.println(iterator.nextTreeNode().val);
		}
	}

}
