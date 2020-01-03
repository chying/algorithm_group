package algorithm.exercise.tree.exe;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	private static TreeNode buildTree() {
		root = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		root.left = node9;
		root.right = node20;
		node20.left = node15;
		node20.right = node7;
		return root;
	}

	// µ•¿˝ ¿¡º”‘ÿ
	static TreeNode root;

	public static TreeNode getInstance() {
		if (root == null) {
			root = buildTree();
		}
		return root;
	}

	public static TreeNode getInstance_1() {
		if (root == null) {
			root = buildTree_1();
		}
		return root;
	}

	private static TreeNode buildTree_1() {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		return root;
	}
}
