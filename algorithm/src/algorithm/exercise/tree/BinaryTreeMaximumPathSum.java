package algorithm.exercise.tree;

/**
 * 【124. 二叉树中的最大路径和】
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 
 * @author chying
 *
 */
public class BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int max = 0;
		helper(root, max);
		return max;
	}

	private int helper(TreeNode node, int max) {
		if (node == null) {
			return 0;
		}
		max = Math.max(max, max + node.val);
		helper(node.left, max);
		helper(node.right, max);
		return 0;

	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum a = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(a.maxPathSum(root));
	}
}
