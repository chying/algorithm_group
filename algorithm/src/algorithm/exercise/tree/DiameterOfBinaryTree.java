package algorithm.exercise.tree;

/**
 * ¡¾543. ¶þ²æÊ÷µÄÖ±¾¶¡¿https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 
 * @author chying
 *
 */
public class DiameterOfBinaryTree {

	int ans;

	public int diameterOfBinaryTree(TreeNode root) {
		ans = 1;
		depth(root);
		return ans - 1;
	}

	public int depth(TreeNode node) {
		if (node == null)
			return 0;
		int L = depth(node.left);
		int R = depth(node.right);
		ans = Math.max(ans, L + R + 1);
		return Math.max(L, R) + 1;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree a = new DiameterOfBinaryTree();
	}
}
