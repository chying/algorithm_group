package algorithm.exercise.tree.exe;

/**
 * ¡¾543. ¶þ²æÊ÷µÄÖ±¾¶¡¿https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 
 * @author chying
 *
 */
public class DiameterOfBinaryTree {
	private int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return max;
	}

	private int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = helper(node.left);
		int right = helper(node.right);
		max = Math.max(left + right, max);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree a = new DiameterOfBinaryTree();
		TreeNode root = TreeNode.getInstance();
		System.out.println(a.diameterOfBinaryTree(root));
	}
}
