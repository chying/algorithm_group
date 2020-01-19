package algorithm.contest.second;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class Contest_172_03 {

	public static void main(String[] args) {
		Contest_172_03 a = new Contest_172_03();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		System.out.println(a.removeLeafNodes(root, 2));
	}

	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
		if (root.left == null && root.right == null && root.val == target) {
			return null;
		}
		return root;
	}

}
