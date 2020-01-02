package algorithm.exercise.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树 最大深度
 * 
 * @author chying
 *
 */
public class MaxTreeDepth {

	public int maxDepth_BFS(TreeNode root) {
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

	public static void main(String[] args) {
		MaxTreeDepth a = new MaxTreeDepth();
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		System.out.println(a.maxDepth(node3));
	}

	public int maxDepth(TreeNode root) {
		if (root != null) {
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			return (left > right ? left : right) + 1;
		}
		return 0;
	}

}
