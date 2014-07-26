package tree;

import commonDataStructures.TreeNode;

/**
 * Not tested yet
 * 
 * @author shen
 * 
 */
public class Merge_Two_BSTs_Into_One {
	static public TreeNode mergeTwoBSTs(TreeNode T1, TreeNode T2) {
		TreeNode x1 = BSTtoLinkedList.B2LIterative(T1);
		TreeNode x2 = BSTtoLinkedList.B2LIterative(T2);
		TreeNode head = new TreeNode(-1);
		TreeNode p = head;
		while (x1 != null && x2 != null) {
			if (x1.val < x2.val) {
				p.right = x1;
				p = p.right;
				x1 = x1.right;
			} else {
				p.right = x2;
				p = p.right;
				x2 = x2.right;
			}
		}

		if (x1 != null) {
			p.right = x2;
		} else if (x2 != null) {
			p.right = x1;
		}

		return BSTtoLinkedList.DLinkListToBST(head.right);
	}
}
