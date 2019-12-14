package algorithm.chapter2.exe.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 【98. 验证二叉搜索树】
 * 
 * @author chying
 *
 */
public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		if (null != root) {
			// 中序遍历二叉树
			List<Integer> ans = new ArrayList<>();
			helper(root, ans);
			for (int i = 1; i < ans.size(); i++) {
				if (ans.get(i) - ans.get(i - 1) < 0) {
					return false;
				}
			}
		}
		return true;
	}

	private void helper(TreeNode node, List<Integer> ans) {
		if (null == node) {
			return;
		}
		if (node.left != null) {
			helper(node.left, ans);
		}
		ans.add(node.val);
		if (node.right != null) {
			helper(node.right, ans);
		}
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree a = new ValidateBinarySearchTree();
		// [-2147483648,null,2147483647]
		TreeNode node1 = new ValidateBinarySearchTree().new TreeNode(1);
		TreeNode node2 = new ValidateBinarySearchTree().new TreeNode(2);
		TreeNode node3 = new ValidateBinarySearchTree().new TreeNode(3);
		node2.left = node1;
		node2.right = node3;
		System.out.println(a.isValidBST(node2));
	}

	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;

		int val = node.val;
		if (lower != null && val <= lower)
			return false;
		if (upper != null && val >= upper)
			return false;

		if (!helper(node.right, val, upper))
			return false;
		if (!helper(node.left, lower, val))
			return false;
		return true;
	}

	public boolean isValidBST1(TreeNode root) {
		return helper(root, null, null);
	}

}
