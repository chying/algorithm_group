package algorithm.exercise.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ��437. ·���ܺ� III�� https://leetcode-cn.com/problems/path-sum-iii/
 * 
 * @author chying
 *
 */
public class PathSumiii {
	private int result = 0;
	int[] arr = new int[1000];
	int size = 0;

	public int pathSum(TreeNode root, int sum) {
		helper(root, sum);
		return result;
	}

	private void helper(TreeNode node, int sum) {
		if (node == null) {
			return;
		}
		int temp = 0;
		arr[size] = node.val;
		for (int i = size; i >= 0; i--) {
			temp += arr[i] ;
			if (temp == sum) {
				result++;
			}
		}
		size++;
		helper(node.left, sum);
		helper(node.right, sum);
		size--;
	}

	public static void main(String[] args) {
		PathSumiii a = new PathSumiii();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);
		System.out.println(a.pathSum(root, 8));
	}
}
