package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import commonDataStructures.TreeNode;

public class All_Possible_Path_Sum_To_K {

	public static ArrayList<ArrayList<TreeNode>> allPossibleSum(TreeNode root,
			int k) {
		ArrayList<ArrayList<TreeNode>> paths = new ArrayList<>();
		HashMap<TreeNode, HashSet<Integer>> map = new HashMap<>();
		allPossibleSumHelper(root, paths, map, k);

		return paths;
	}

	private static void allPossibleSumHelper(TreeNode T,
			ArrayList<ArrayList<TreeNode>> paths,
			HashMap<TreeNode, HashSet<Integer>> map, int k) {
		if (T == null)
			return;
		map.put(T, new HashSet<Integer>());
		map.get(T).add(T.val);

		allPossibleSumHelper(T.left, paths, map, k);
		allPossibleSumHelper(T.right, paths, map, k);

		if (T.left != null)
			for (int i : map.get(T.left)) {
				map.get(T).add(T.val + i);
			}
		if (T.right != null)
			for (int i : map.get(T.right)) {
				map.get(T).add(T.val + i);
				if (T.left != null && map.get(T.left).contains(k - T.val - i))
					System.out.println(T.val);

			}

		if (map.get(T).contains(k))
			System.out.println(T.val);

	}

	/**
	 * Find path part has not been finished
	 * 
	 * @param args
	 */
	// private static ArrayList<ArrayList<TreeNode>> findPath(TreeNode T,
	// HashMap<TreeNode, HashSet<Integer>> map, ArrayList<TreeNode> tmp,
	// int k) {
	// if (T.val == k) {
	// tmp.add(T);
	// return tmp;
	// }
	// else{
	// k = k-T.val;
	// if(T.left!=null && map.get(T.left).contains(k-val))
	// return
	// }
	// }

	public static void main(String args[]) {
		TreeNode root = TreeNode.generateBST();
		// TreeNode.inOrderTravel(root);

		allPossibleSum(root, 8);
	}
}
