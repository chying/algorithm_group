package algorithm.exercise.tree;

/**
 * 【538. 把二叉搜索树转换为累加树】
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 
 * @author chying
 *
 */
public class ConvertBstToGreaterTree {
	private int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		if (root != null) {
			convertBST(root.right);
			sum += root.val;
			root.val = sum;
			convertBST(root.left);
		}
		return root;
	}

	public static void main(String[] args) {
		ConvertBstToGreaterTree a = new ConvertBstToGreaterTree();

		TreeNode node = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node13 = new TreeNode(13);
		node.left = node2;
		node.right = node13;
		a.convertBST(node);
	}
}
