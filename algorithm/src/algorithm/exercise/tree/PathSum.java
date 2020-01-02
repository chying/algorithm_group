package algorithm.exercise.tree;

/**
 * ¡¾112. Â·¾¶×ÜºÍ¡¿ https://leetcode-cn.com/problems/path-sum/
 * 
 * @author chying
 *
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		sum -= root.val;
		if ((root.left == null) && (root.right == null))
			return (sum == 0);
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}

	public static void main(String[] args) {
		PathSum a = new PathSum();
		TreeNode root = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node41 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		root.left = node4;
		root.right = node8;
		node4.left = node11;
		node11.left = node7;
		node11.right = node2;
		node8.left = node13;
		node8.right = node41;
		node4.right = node1;
		System.out.println(a.hasPathSum(root, 22));
	}
}
