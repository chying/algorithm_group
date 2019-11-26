package algorithm.exercise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树 最大深度
 * 
 * @author chying
 *
 */
public class MaxTreeDepth {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		int depth = 0;
		if (null != root) {
			Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
			queue.addLast(root);
			while (queue.size() > 0) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.pollFirst();
					if (node.left != null) {
						queue.addLast(node.left);
					}
					if (node.right != null) {
						queue.addLast(node.right);
					}
				}
				depth++;
			}
		}
		return depth;
	}

//	public int getMaxDepth(TreeNode node, int depth) {
//		if (node == null) {
//			return depth;
//		}
//		if (node.left != null) {
//			getMaxDepth(node.left, depth + 1);
//		}
//		if (node.right != null) {
//			getMaxDepth(node.left, depth + 1);
//		}
//		return depth;
//	}

	public static void main(String[] args) {
		MaxTreeDepth a = new MaxTreeDepth();
		TreeNode node3 = new MaxTreeDepth().new TreeNode(3);
		TreeNode node9 = new MaxTreeDepth().new TreeNode(9);
		TreeNode node20 = new MaxTreeDepth().new TreeNode(20);
		TreeNode node15 = new MaxTreeDepth().new TreeNode(15);
		TreeNode node7 = new MaxTreeDepth().new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		System.out.println(a.maxDepth1(node3));
	}

	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
		return depth;
	}

}
