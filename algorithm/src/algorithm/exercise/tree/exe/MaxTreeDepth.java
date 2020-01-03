package algorithm.exercise.tree.exe;

/**
 * �� 104�������� �����ȡ�
 * 
 * @author chying
 *
 */
public class MaxTreeDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;
		return left > right ? left : right;
	}

	public static void main(String[] args) {
		MaxTreeDepth a = new MaxTreeDepth();
		TreeNode root = TreeNode.getInstance();
		System.out.println(a.maxDepth(root));
	}

}
