package tree;

import java.util.Stack;

import commonDataStructures.TreeNode;

public class inOrderBinaryTreeIterator_reverst {
	TreeNode root;
	Stack<TreeNode> stack;
	boolean flag;
	TreeNode buffer;

	public inOrderBinaryTreeIterator_reverst(TreeNode T) {
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
			while (stack.peek().right != null)
				stack.push(stack.peek().right);
			flag = false;
			TreeNode tmp = stack.pop();
			if (tmp.left != null)
				stack.push(tmp.left);

			return tmp;
		} else {
			if (stack.peek().left == null)
				return stack.pop();
			else {
				TreeNode tmp = stack.pop();
				stack.push(tmp.left);
				flag = true;
				return tmp;
			}
		}

	}

	public static void main(String args[]) {
		TreeNode rootNode = TreeNode.generateBST();
		inOrderBinaryTreeIterator_reverst iterator = new inOrderBinaryTreeIterator_reverst(
				rootNode);
		while (iterator.hasNext()) {
			System.out.println(iterator.nextTreeNode().val);
		}
	}

}
