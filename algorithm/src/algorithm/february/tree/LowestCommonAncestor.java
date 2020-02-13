package algorithm.february.tree;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;

	}

	public static void main(String[] args) {
		LowestCommonAncestor a = new LowestCommonAncestor();
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(5);
		t1.right = new TreeNode(1);
		t1.left.left = new TreeNode(6);
		t1.left.right = new TreeNode(2);
		t1.right.left = new TreeNode(0);
		t1.right.right = new TreeNode(8);
		t1.left.right.left = new TreeNode(7);
		t1.left.right.right = new TreeNode(4);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(9);
		a.lowestCommonAncestor(t1, p, q);
	}
}
