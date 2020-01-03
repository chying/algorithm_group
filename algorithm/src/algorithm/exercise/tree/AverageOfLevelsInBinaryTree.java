package algorithm.exercise.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 【637.
 * 二叉树的层平均值】https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * 
 * @author chying
 *
 */
public class AverageOfLevelsInBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		if (root != null) {
			Deque<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				Double sum = 0.0;
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					sum += node.val;
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
				result.add(sum / size);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		AverageOfLevelsInBinaryTree a = new AverageOfLevelsInBinaryTree();
		TreeNode root = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		root.left = node9;
		root.right = node20;
		node20.left = node15;
		node20.right = node7;
		System.out.println(a.averageOfLevels(root));
	}
}
