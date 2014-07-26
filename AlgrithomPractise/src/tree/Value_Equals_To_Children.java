package tree;

import commonDataStructures.TreeNode;

/**
 * Untested Write a function that returns true if the tree satisfies below
 * property a) for every internal node, data value must be equal to sum of data
 * values in left and righ children b) if a node has only one child, consider
 * data value of other child as 0
 * 
 * @author shen
 * 
 */
public class Value_Equals_To_Children {

	static public int isValueEqualsToChildenSum(TreeNode root) {
		if (root == null)
			return 0;
		int leftValue, rightVale;
		leftValue = isValueEqualsToChildenSum(root.left);
		if (leftValue >= 0)
			rightVale = isValueEqualsToChildenSum(root.right);
		else {
			return -1;
		}
		if (rightVale >= 0 && root.val == (rightVale + leftValue))
			return root.val;
		else
			return -1;
	}
}
