package algorithm.exercise.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 【101. 对称二叉树】https://leetcode-cn.com/problems/symmetric-tree/
 * 
 * @author chying
 *
 */
public class SymmetricTree {
	/**
	 * 层次遍历
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric_1(TreeNode root) {
		if (root != null) {
			Deque<TreeNode> deque = new ArrayDeque<>();
			deque.add(root);
			deque.add(root);
			while (!deque.isEmpty()) {
				TreeNode nodeL = deque.poll();
				TreeNode nodeR = deque.poll();
				if (nodeL == null && nodeR == null) {
					continue;
				}
				if (nodeL == null || nodeR == null) {
					return false;
				}
				if (nodeL.val != nodeR.val)
					return false;
				deque.add(nodeL.left);
				deque.add(nodeR.right);
				deque.add(nodeL.right);
				deque.add(nodeR.left);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SymmetricTree a = new SymmetricTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node43 = new TreeNode(4);
		TreeNode node44 = new TreeNode(4);
		node1.left = node2;
		node1.right = node22;
		node2.left = node3;
		node2.right = node4;
		node22.left = node43;
		node22.right = node44;
		System.out.println(a.isSymmetric(node1));
	}

	private boolean isSymmetric(TreeNode root) {
		if (root != null) {
			return helper(root.left, root.right);
		}
		return true;
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val == right.val) {
			return helper(left.left, right.right) && helper(left.right, right.left);
		}
		return false;
	}

	public boolean isSymmetric_re(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}

}
