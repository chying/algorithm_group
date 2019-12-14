package algorithm.chapter2.exe.bintree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 【给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。】 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 
 * @author chying
 *
 */
public class NAryTreeLevelOrderTraversal {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (null != root) {
			Deque<Node> deque = new ArrayDeque<>();
			deque.addFirst(root);
			while (!deque.isEmpty()) {
				Node node = deque.pollFirst();
				List<Integer> subResult = new ArrayList<>();
				subResult.add(node.val);
				if (null != node.children) {
					for (Node child : node.children) {
						deque.addFirst(child);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		NAryTreeLevelOrderTraversal a = new NAryTreeLevelOrderTraversal();
		Node node5 = new NAryTreeLevelOrderTraversal().new Node(5, null);
		Node node6 = new NAryTreeLevelOrderTraversal().new Node(6, null);
		Node node3 = new NAryTreeLevelOrderTraversal().new Node(3, Arrays.asList(node5, node6));
		Node node2 = new NAryTreeLevelOrderTraversal().new Node(2, null);
		Node node4 = new NAryTreeLevelOrderTraversal().new Node(4, null);
		Node node1 = new NAryTreeLevelOrderTraversal().new Node(1, Arrays.asList(node3, node2, node4));

		System.out.println(a.levelOrder(node1));

	}
}
