package algorithm.exercise.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 【103. 二叉树的锯齿形层次遍历】
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * @author chying
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal a = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode node = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		node.left = node1;
		node.right = node2;
		node2.left = node3;
		node2.right = node4;
		List<List<Integer>> result = a.zigzagLevelOrder(node);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean order = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode n = queue.poll();
				if (order) {
					subList.add(n.val);
				} else {
					subList.add(0, n.val);
				}
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
			result.add(subList);
			order = !order;
		}
		return result;
	}
	
	
	public List<List<Integer>> zigzagLevelOrder_1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean order = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new LinkedList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode n = queue.poll();
				if (order) {
					subList.add(n.val);
				} else {
					subList.add(0, n.val);
				}
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
			result.add(subList);
			order = !order;
		}
		return result;
	}
}
