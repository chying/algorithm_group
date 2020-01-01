package algorithm.exercise.tree;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 【230.
 * 二叉搜索树中第K小的元素】https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 
 * @author chying
 *
 */
public class KthSmallestElementInABst {

	private int val;
	private int size;

	public int kthSmallest(TreeNode root, int k) {
		int result = 0;
		if (null != root && k > 0) {
			PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>(k, new MyComparator());
			Deque<TreeNode> deque = new ArrayDeque<>();
			deque.add(root);
			while (!deque.isEmpty()) {
				TreeNode node = deque.poll();
				if (priorityQueue.size() >= k && priorityQueue.peek().val > node.val) {
					priorityQueue.poll();
				}
				if (priorityQueue.size() < k) {
					priorityQueue.add(node);
				}
				if (node.left != null) {
					deque.add(node.left);
				}
				if (node.right != null) {
					deque.add(node.right);
				}
			}
			return priorityQueue.peek().val;
		}
		return result;
	}

	class MyComparator implements Comparator<TreeNode> {

		@Override
		public int compare(TreeNode o1, TreeNode o2) {
			return o2.val - o1.val;
		}

	}

	public static void main(String[] args) {
		KthSmallestElementInABst a = new KthSmallestElementInABst();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		System.out.println(a.kthSmallest_inorder(node1, 2));

	}

	public int kthSmallest_inorder(TreeNode root, int k) {
		if (null != root && k > 0) {
			inOrderTree(root, k);
			return val;
		}
		return val;
	}

	private void inOrderTree(TreeNode node, int k) {
		if (node == null) {
			return;
		}
		inOrderTree(node.left, k);
		if (++size == k) {
			val = node.val;
			return;
		}
		inOrderTree(node.right, k);
	}

	public class KthSmallest230 {
		private int i = 0;
		private int val = 0;
		
		public int kthSmallest(TreeNode root, int k) {
			ldr(root, k);
			return val;
		}

		public void ldr(TreeNode root, int k) {
			if (root == null) {
				return;
			}
			ldr(root.left, k);
			if (k == ++i) {
				val = root.val;
			}
			ldr(root.right, k);
		}
	}

}
