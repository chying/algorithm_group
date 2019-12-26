package algorithm.chapter2.exe.recursion;

/**
 * ��111. ����������С��ȡ�
 * 
 * @author chying
 *
 */
public class MinimumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left_height = minDepth(root.left);
			int right_height = minDepth(root.right);
			return Math.min(left_height, right_height) + 1;
		}
	}

	public static void main(String[] args) {
		MinimumDepthOfBinaryTree a = new MinimumDepthOfBinaryTree();
		TreeNode node3 = new MinimumDepthOfBinaryTree().new TreeNode(3);
		TreeNode node9 = new MinimumDepthOfBinaryTree().new TreeNode(9);
		TreeNode node20 = new MinimumDepthOfBinaryTree().new TreeNode(20);
		TreeNode node15 = new MinimumDepthOfBinaryTree().new TreeNode(15);
		TreeNode node7 = new MinimumDepthOfBinaryTree().new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		System.out.println(a.minDepth(node3));
	}
}