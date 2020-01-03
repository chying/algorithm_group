package algorithm.exercise.tree;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class SumOfLeftLeaves {
	
	private int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root != null) {
			helper(root, false);
		}
		return sum;
	}

	private void helper(TreeNode node, boolean isLeft) {
		// Ò¶×Ó½Úµã
		if (node.left == null && node.right == null && isLeft) {
			sum += node.val;
			return;
		}

		if (node.left != null) {
			helper(node.left, true);
		}

		if (node.right != null) {
			helper(node.right, false);
		}
	}

	public static void main(String[] args) {
		SumOfLeftLeaves a = new SumOfLeftLeaves();
		TreeNode root = new TreeNode(3);
		TreeNode node11 = new TreeNode(9);
		TreeNode node12 = new TreeNode(20);
		TreeNode node21 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		root.left = node11;
		root.right = node12;
		node12.left = node21;
		node12.right = node7;

		System.out.println(a.sumOfLeftLeaves(root));
	}
}
