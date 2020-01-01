package algorithm.chapter2.exe.bintree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【111. 二叉树的最小深度】
 * 
 * @author chying
 *
 */
public class MaximumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if (root != null) {
			int result = 0;
			Deque<TreeNode> deque = new ArrayDeque<>();
			deque.add(root);
			while (!deque.isEmpty()) {
				int size = deque.size();
				result++;
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.poll();
					if (node.left != null) {
						deque.add(node.left);
					}
					if (node.right != null) {
						deque.add(node.right);
					}
				}
			}
			return result;
		}
		return 0;
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
		TreeNode node3 = new MaximumDepthOfBinaryTree().new TreeNode(3);
		TreeNode node9 = new MaximumDepthOfBinaryTree().new TreeNode(9);
		TreeNode node20 = new MaximumDepthOfBinaryTree().new TreeNode(20);
		TreeNode node15 = new MaximumDepthOfBinaryTree().new TreeNode(15);
		TreeNode node7 = new MaximumDepthOfBinaryTree().new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		System.out.println(a.maxDepth_recursion(node3));
	}

	public int maxDepth_recursion(TreeNode root) {
		int result = 0;
		if (root != null) {
			result = helper(root, 0);
		}
		return result;
	}

	private int helper(TreeNode node, int level) {
		if (node == null) {
			return level;
		}

		int left = helper(node.left, level + 1);
		int right = helper(node.right, level + 1);

		return left > right ? left : right;
	}
}
