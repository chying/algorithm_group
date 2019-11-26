package algorithm.chapter2.first;

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

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			if (root.left != null) {
				result.addAll(inorderTraversal(root.left));
			}
			result.add(root.val);
			if (root.right != null) {
				result.addAll(inorderTraversal(root.right));
			}
		}
		return result;
	}

	/**
	 * 前序遍历
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			result.add(root.val);
			if (root.left != null) {
				result.addAll(preorderTraversal(root.left));
			}		
			if (root.right != null) {
				result.addAll(preorderTraversal(root.right));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeTraversal a = new BinaryTreeTraversal();
		TreeNode root = new BinaryTreeTraversal().new TreeNode(1);
		TreeNode leftNode = new BinaryTreeTraversal().new TreeNode(2);
		TreeNode rightNode = new BinaryTreeTraversal().new TreeNode(3);
		root.left = leftNode;
		root.right = rightNode;
		List<Integer> result = a.inorderTraversal(root);
		for (Integer val : result) {
			System.out.println(val + "");
		}

	}
}
