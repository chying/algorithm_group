package algorithm.chapter2.template;

import algorithm.chapter2.template.MinimumDepthOfBinaryTree.TreeNode;

/**
 * 【111. 二叉树的最小深度】
 * 
 * @author chying
 *
 */
public class MaximumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		return 0;
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
		TreeNode node3 = new MaximumDepthOfBinaryTree().new TreeNode(3);
		TreeNode node9 = new MaximumDepthOfBinaryTree().new TreeNode(9);
		TreeNode node20 = new MaximumDepthOfBinaryTree().new TreeNode(20);
		TreeNode node15 = new MaximumDepthOfBinaryTree().new TreeNode(15);
		TreeNode node7 = new MaximumDepthOfBinaryTree().new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		System.out.println(a.maxDepth(node3));
	}
}
