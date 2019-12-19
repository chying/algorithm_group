package algorithm.chapter2.exe.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【226. 翻转二叉树】翻转一棵二叉树。
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 * 
 * @author chying
 *
 */
public class InvertBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (null != root) {
			invertTree_helper(root);
		}
		return root;
	}

//层次遍历
	private void invertTree_helper(TreeNode node) {
		if (node == null) {
			return;
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.addFirst(node);
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode no = deque.pollLast();
				if (no.left != null || no.right != null) {
					if(no.left != null) {
						deque.addFirst(no.left);
					}
					if(no.right != null) {
						deque.addFirst(no.right);
					}
					TreeNode temp = no.left;
					no.left = no.right;
					no.right = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		InvertBinaryTree a = new InvertBinaryTree();
		TreeNode node4 = new InvertBinaryTree().new TreeNode(4);
		TreeNode node2 = new InvertBinaryTree().new TreeNode(2);
		TreeNode node7 = new InvertBinaryTree().new TreeNode(7);
		TreeNode node1 = new InvertBinaryTree().new TreeNode(1);
		TreeNode node3 = new InvertBinaryTree().new TreeNode(3);
		TreeNode node6 = new InvertBinaryTree().new TreeNode(6);
		TreeNode node9 = new InvertBinaryTree().new TreeNode(9);
		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;
		TreeNode node = a.invertTree(node4);

	}
}
