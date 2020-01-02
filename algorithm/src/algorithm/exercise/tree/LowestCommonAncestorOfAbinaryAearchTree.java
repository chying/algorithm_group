package algorithm.exercise.tree;

/**
 * 【235. 二叉搜索树的最近公共祖先】
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * @author chying
 *
 */
public class LowestCommonAncestorOfAbinaryAearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root != null && p != null && q != null && q.val != p.val) {
			int min = p.val > q.val ? q.val : p.val;
			int max = p.val < q.val ? q.val : p.val;
			return helper(root, min, max);
		}
		return null;
	}

	private TreeNode helper(TreeNode node, int min, int max) {
		if (node == null) {
			return null;
		}
		if (min <= node.val && max >= node.val) {
			return node;
		} else {
			if (max < node.val) {
				return helper(node.left, min, max);
			} else {
				return helper(node.right, min, max);
			}
		}
	}

	public static void main(String[] args) {
		LowestCommonAncestorOfAbinaryAearchTree a = new LowestCommonAncestorOfAbinaryAearchTree();
		TreeNode root = new TreeNode(6);
		TreeNode node11 = new TreeNode(2);
		TreeNode node12 = new TreeNode(8);
		TreeNode node21 = new TreeNode(0);
		TreeNode node22 = new TreeNode(4);
		TreeNode node23 = new TreeNode(7);
		TreeNode node24 = new TreeNode(9);
		TreeNode node31 = new TreeNode(3);
		TreeNode node32 = new TreeNode(5);
		root.left = node11;
		root.right = node12;
		node11.left = node21;
		node11.right = node22;
		node12.left = node23;
		node12.right = node24;
		node22.left = node31;
		node22.right = node32;
		System.out.println(a.lowestCommonAncestor(root, node11, node22).val);
	}

	public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor_1(root.left, p, q);
		if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor_1(root.right, p, q);
		return root;
	}

}
