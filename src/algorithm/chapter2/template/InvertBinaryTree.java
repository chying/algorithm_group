package algorithm.chapter2.template;

/**
 * 【226. 翻转二叉树】翻转一棵二叉树。
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 * 
 * @author chying
 *
 */
public class InvertBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (null == root) {
			return null;
		}
//		if (root.left != null && root.right != null) {
//			
//			invertTree(root.left);
//			invertTree(root.right);
//		}
		invertTree1(root);
		return invertTree(root);
	}

	private void invertTree1(TreeNode node) {
		// terminate
		if (node.left == null || node.right == null) {
			return;
		}else {
//			if() {
//				
//			}
		}
		// process
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		// drill down
		invertTree1(node.left);
		invertTree1(node.right);
	}

	public static void main(String[] args) {
		InvertBinaryTree a = new InvertBinaryTree();
		TreeNode node4 = new InvertBinaryTree().new TreeNode(4);
		TreeNode node2 = new InvertBinaryTree().new TreeNode(2);
		TreeNode node7 = new InvertBinaryTree().new TreeNode(7);
		TreeNode node1 = new InvertBinaryTree().new TreeNode(1);
		TreeNode node3 = new InvertBinaryTree().new TreeNode(3);
		TreeNode node6 = new InvertBinaryTree().new TreeNode(6);
		TreeNode node9 = new InvertBinaryTree().new TreeNode(9);
		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;
		TreeNode node = a.invertTree(node4);

	}
}
