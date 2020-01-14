package algorithm.exercise.a;

public class ValidBFSTree2 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	long pre = Long.MIN_VALUE;

	public boolean isValidBST33(TreeNode root) {
		return helper(root);
	}

	private boolean helper(TreeNode node) {
		if (node == null) {
			return true;
		}
		if (node.left != null) {
			if (!helper(node.left)) {
				return false;
			}
		}
		if (pre >= node.val) {
			return false;
		} else {
			pre = node.val;
		}
		if (node.right != null) {
			if (!helper(node.right)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidBFSTree2 a = new ValidBFSTree2();
		TreeNode node3 = a.new TreeNode(10);
		TreeNode node9 = a.new TreeNode(5);
		TreeNode node20 = a.new TreeNode(15);
		TreeNode node15 = a.new TreeNode(6);
		TreeNode node7 = a.new TreeNode(20);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
//		[5,1,4,null,null,3,6]
//		[10,5,15,null,null,6,20]
		System.out.println(a.isValidBST(node3));
	}

	private double last = -Double.MAX_VALUE;

	private boolean dfs(TreeNode root) {
		if (root == null)
			return true;
		if (dfs(root.left)) {
			if (last < root.val) {
				last = root.val;
				return dfs(root.right);
			}
		}
		return false;
	}

	public boolean isValidBST(TreeNode root) {
		// System.out.println(last);
		return dfs(root);
	}

}
