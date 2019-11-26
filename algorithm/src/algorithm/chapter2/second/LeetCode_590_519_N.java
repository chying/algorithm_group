package algorithm.chapter2.second;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 
 * @author chying
 *
 */
public class LeetCode_590_519_N {

	// Definition for a Node.
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

	public List<Integer> postorder(Node root) {
		if (root == null) {
			return null;
		}

		List<Integer> result = new ArrayList<>();
		return postorder(result, root);
	}

	private List<Integer> postorder(List<Integer> result, Node node) {
		// ×óÓÒ¸ù
//		if (node.children != null) {
//			postorder(result);
//		}
		Node n = new Node(node.val, null);
		return result;
	}
}
