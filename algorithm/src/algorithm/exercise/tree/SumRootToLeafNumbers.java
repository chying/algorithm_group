package algorithm.exercise.tree;

/**
 * 【129. 求根到叶子节点数字之和】 https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 
 * @author chying
 *
 */
public class SumRootToLeafNumbers {
	private int sum = 0;

	public int sumNumbers(TreeNode root) {
		helper(root, 0);
		return sum;
	}

	private int helper(TreeNode node, int cur) {
		if (node == null) {
			return sum;
		}
		cur = cur * 10 + node.val;
		if (node.left == null && node.right == null) {
			sum += cur;
		} else {
			helper(node.left, cur);
			helper(node.right, cur);
		}
		return sum;
	}

	public static void main(String[] args) {
		SumRootToLeafNumbers a = new SumRootToLeafNumbers();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(a.sumNumbers(root));
	}
}
