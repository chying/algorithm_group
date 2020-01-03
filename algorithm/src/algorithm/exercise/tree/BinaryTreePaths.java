package algorithm.exercise.tree;

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
		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.val);
		if (root.left != null)
			searchBT(root.left, path + root.val + "->", answer);
		if (root.right != null)
			searchBT(root.right, path + root.val + "->", answer);
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
