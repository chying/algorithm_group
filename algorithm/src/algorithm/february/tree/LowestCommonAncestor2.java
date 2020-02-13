package algorithm.february.tree;

public class LowestCommonAncestor2 {

	private int min;
	private int max;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		min = Math.min(p.val, q.val);
		max = Math.max(p.val, q.val);
		return lowestCommonAncestor(root, min, max);
	}

	private TreeNode lowestCommonAncestor(TreeNode root, int min, int max) {
		if (root == null || root.val == min || root.val == max) {
			return root;
		}
		TreeNode node;
		if (root.val > max) {
			node = lowestCommonAncestor(root.left, min, max);
		} else if (root.val < min) {
			node = lowestCommonAncestor(root.right, min, max);
		} else {
			node = root;
		}
		return node;
	}

	public static void main(String[] args) {
		LowestCommonAncestor2 a = new LowestCommonAncestor2();
		TreeNode t1 = new TreeNode(6);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(8);
		t1.left.left = new TreeNode(0);
		t1.left.right = new TreeNode(4);
		t1.right.left = new TreeNode(7);
		t1.right.right = new TreeNode(9);
		t1.left.right.left = new TreeNode(3);
		t1.left.right.right = new TreeNode(5);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		System.out.println(a.lowestCommonAncestor(t1, p, q).val);
	}
}
