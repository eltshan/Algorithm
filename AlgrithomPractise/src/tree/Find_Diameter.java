package tree;

import commonDataStructures.TreeNode;

public class Find_Diameter {

	public static int findDiameter(TreeNode root) {
		if (root == null)
			return 0;
		return findDiameter(root, new int[1]);

	}

	private static int findDiameter(TreeNode T, int[] longestPath) {
		if (T == null)
			return 0;
		int longestLeft[] = new int[1];
		int longestRight[] = new int[1];

		int fd = findDiameter(T.left, longestLeft);
		int ld = findDiameter(T.right, longestRight);

		int currentDiameter = longestLeft[0] + longestRight[0] + 1;
		longestPath[0] = Math.max(longestLeft[0], longestRight[0]) + 1;

		return Math.max(currentDiameter, Math.max(fd, ld));

	}

	public static void main(String args[]) {
		TreeNode root = TreeNode.generateBST();
		int d = findDiameter(root);
		System.out.println(d);
	}
}
