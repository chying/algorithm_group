package algorithm.chapter2.exe.bintree;

import java.util.ArrayList;
import java.util.List;

/**
 * 【二叉树的中序遍历】给定一个二叉树，返回它的中序 遍历。 示例: 输入: [1,null,2,3] 1 \ 2 / 3 输出: [1,3,2]
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 
 * @author chying
 *
 */
public class BinaryTreeTraversal {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 中序遍历 左根右
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (null != root) {
			inorderTraversal_helper(root, result);
		}
		return result;
	}

	private void inorderTraversal_helper(TreeNode node, List<Integer> result) {
		if (null == node) {
			return;
		}
		if (null != node.left) {
			inorderTraversal_helper(node.left, result);
		}
		result.add(node.val);
		if (null != node.right) {
			inorderTraversal_helper(node.right, result);
		}
	}

	/**
	 * 前序遍历 根左右
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (null != root) {
			preorderTraversal_helper(root, result);
		}
		return result;
	}

	private void preorderTraversal_helper(TreeNode node, List<Integer> result) {
		if (null == node) {
			return;
		}
		result.add(node.val);
		if (null != node.left) {
			inorderTraversal_helper(node.left, result);
		}

		if (null != node.right) {
			inorderTraversal_helper(node.right, result);
		}
	}

	public static void main(String[] args) {
		BinaryTreeTraversal a = new BinaryTreeTraversal();
		TreeNode node1 = new BinaryTreeTraversal().new TreeNode(1);
		TreeNode node2 = new BinaryTreeTraversal().new TreeNode(2);
		TreeNode node3 = new BinaryTreeTraversal().new TreeNode(3);

		node1.right = node2;
		node2.left = node3;

		System.out.println(a.inorderTraversal(node1).toString());
		System.out.println(a.preorderTraversal(node1).toString());
	}
}
