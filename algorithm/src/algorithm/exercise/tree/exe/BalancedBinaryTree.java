package algorithm.exercise.tree.exe;

/**
 * 【110. 平衡二叉树】https://leetcode-cn.com/problems/balanced-binary-tree/
 * 
 * @author chying
 *
 */
public class BalancedBinaryTree {
	// 重复子问题，任一节点 左右子树 差
	public boolean isBalanced(TreeNode root) {
		return helper(root) != -1;
	}

	private int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = helper(node.left) ;
		if (left == -1) {
			return -1;
		}
		int right = helper(node.right) ;
		if (right == -1) {
			return -1;
		}
		return Math.abs(left - right) < 2 ? Math.max(left, right)+1 : -1;
	}

	public static void main(String[] args) {
		BalancedBinaryTree a = new BalancedBinaryTree();
		TreeNode root = TreeNode.getInstance_1();
		System.out.println(a.isBalanced(root));
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		if (left == -1)
			return -1;
		int right = depth(root.right);
		if (right == -1)
			return -1;
		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}
}
