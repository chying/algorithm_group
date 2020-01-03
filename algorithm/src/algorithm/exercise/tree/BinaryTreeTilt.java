package algorithm.exercise.tree;

/**
 * ¡¾563. ¶þ²æÊ÷µÄÆÂ¶È¡¿ https://leetcode-cn.com/problems/binary-tree-tilt/
 * 
 * @author chying
 *
 */
public class BinaryTreeTilt {

	int result = 0;

	public int findTilt(TreeNode root) {
		if (root != null) {

			return Math.abs(helper(root.left, 0) - helper(root.right, 0));
		}
		return 0;
	}

	private int helper(TreeNode node, int num) {
		if (node == null) {
			return 0;
		}
		num += helper(node.left, num);
		num += helper(node.right, num);
		return node.val;
	}

	public static void main(String[] args) {
		BinaryTreeTilt a = new BinaryTreeTilt();
		TreeNode root = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		root.left = node9;
		root.right = node20;
		node20.left = node15;
		node20.right = node7;
		System.out.println(a.findTilt(root));
	}
}
