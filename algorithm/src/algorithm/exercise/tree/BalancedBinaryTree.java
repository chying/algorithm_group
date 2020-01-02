package algorithm.exercise.tree;

/**
 * ¡¾110. Æ½ºâ¶þ²æÊ÷¡¿https://leetcode-cn.com/problems/balanced-binary-tree/
 * 
 * @author chying
 *
 */
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root != null) {
			int l = depth(root.left);
			int r = depth(root.right);
			if (Math.abs(l - r) > 1) {
				return false;
			}
		}
		return false;
	}

	public int depth(TreeNode node) {
		if (node == null)
			return 0;
		int l = depth(node.left);
		int r = depth(node.right);
		return 0;
	}

	public static void main(String[] args) {
		BalancedBinaryTree a = new BalancedBinaryTree();
	}
}
