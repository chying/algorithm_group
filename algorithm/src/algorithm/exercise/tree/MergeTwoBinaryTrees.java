package algorithm.exercise.tree;

/**
 * ¡¾617. ºÏ²¢¶þ²æÊ÷¡¿
 * 
 * @author chying
 *
 */
public class MergeTwoBinaryTrees {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;

	}

	public static void main(String[] args) {
		MergeTwoBinaryTrees a = new MergeTwoBinaryTrees();
		TreeNode node11 = new MergeTwoBinaryTrees().new TreeNode(1);
		TreeNode node13 = new MergeTwoBinaryTrees().new TreeNode(3);
		TreeNode node12 = new MergeTwoBinaryTrees().new TreeNode(2);
		TreeNode node15 = new MergeTwoBinaryTrees().new TreeNode(5);
		node11.left = node13;
		node11.right = node12;
		node13.left = node15;

		TreeNode node2 = new MergeTwoBinaryTrees().new TreeNode(2);
		TreeNode node21 = new MergeTwoBinaryTrees().new TreeNode(1);
		TreeNode node23 = new MergeTwoBinaryTrees().new TreeNode(3);
		TreeNode node24 = new MergeTwoBinaryTrees().new TreeNode(4);
		TreeNode node27 = new MergeTwoBinaryTrees().new TreeNode(7);
		node2.left = node21;
		node2.right = node23;
		node21.right = node24;
		node23.right = node27;

		a.mergeTrees(node11, node2);
	}
}
