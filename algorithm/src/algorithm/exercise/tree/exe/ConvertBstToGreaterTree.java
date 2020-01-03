package algorithm.exercise.tree.exe;

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
		helper(root);
		return root;
	}

	private void helper(TreeNode node) {
		if (node == null) {
			return;
		}
		helper(node.right);
		sum += node.val;
		node.val = sum;
		helper(node.left);
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
