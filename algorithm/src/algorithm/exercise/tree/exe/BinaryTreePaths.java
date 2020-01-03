package algorithm.exercise.tree.exe;

import java.util.ArrayList;
import java.util.List;

/**
 * 【257. 二叉树的所有路径】 https://leetcode-cn.com/problems/binary-tree-paths/
 * 
 * @author chying
 *
 */
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root != null) {
			helper(root, result, "");
		}
		return result;
	}

	private void helper(TreeNode node, List<String> result, String val) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			result.add(val + node.val);
			return;
		}
		val += node.val + "->";
		helper(node.left, result, val);
		helper(node.right, result, val);
	}

	public static void main(String[] args) {
		BinaryTreePaths a = new BinaryTreePaths();
		TreeNode root = new TreeNode(1);
		TreeNode node11 = new TreeNode(2);
		TreeNode node12 = new TreeNode(3);
		TreeNode node21 = new TreeNode(5);
		root.left = node11;
		root.right = node12;
		node11.right = node21;
		System.out.println(a.binaryTreePaths(root));
	}
}
