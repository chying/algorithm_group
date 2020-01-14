package algorithm.exercise.tree;

/**
 * 【437. 路径总和 III】 https://leetcode-cn.com/problems/path-sum-iii/
 * 
 * @author chying
 *
 */
public class PathSumiii2 {

	public int pathSum(TreeNode root, int sum) {
		return pathSum(root, sum, new int[1000], 0);
	}

	public int pathSum(TreeNode root, int sum, int[] array/* 保存路径 */, int p/* 指向路径终点 */) {
		if (root == null) {
			return 0;
		}
		int tmp = root.val;
		int n = root.val == sum ? 1 : 0;
		for (int i = p - 1; i >= 0; i--) {
			tmp += array[i];
			if (tmp == sum) {
				n++;
			}
		}
		array[p] = root.val;
		int n1 = pathSum(root.left, sum, array, p + 1);
		int n2 = pathSum(root.right, sum, array, p + 1);
		return n + n1 + n2;
	}

	public static void main(String[] args) {
		PathSumiii2 a = new PathSumiii2();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-1);
		root.left.right.right = new TreeNode(1);
		System.out.println(a.pathSum(root, 8));
	}
}
