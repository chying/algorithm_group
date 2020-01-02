package algorithm.exercise.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 【107. 二叉树的层次遍历 II】
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * @author chying
 *
 */
public class BinaryTreeLevelOrderTraversalii {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		if (root != null) {
			Deque<TreeNode> deque = new LinkedList<>();
			deque.add(root);
			while (!deque.isEmpty()) {
				int size = deque.size();
				List<Integer> subList = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.poll();
					subList.add(node.val);
					if (node.left != null) {
						deque.add(node.left);
					}
					if (node.right != null) {
						deque.add(node.right);
					}
				}
				result.addFirst(subList);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalii a = new BinaryTreeLevelOrderTraversalii();
		TreeNode node = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node.left = node2;
		node.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println(a.levelOrderBottom(node));
	}
}
