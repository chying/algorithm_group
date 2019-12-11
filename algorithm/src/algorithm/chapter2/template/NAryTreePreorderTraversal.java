package algorithm.chapter2.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ¡¾590. N²æÊ÷µÄºóÐò±éÀú¡¿
 * 
 * @author chying
 *
 */
public class NAryTreePreorderTraversal {
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

	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (null != root) {
			result.add(root.val);
			if (null != root.children) {
				for (Node node : root.children) {
					helper(node, result);
				}
			}
		}
		return result;
	}

	private void helper(Node node, List<Integer> result) {
		if (null == node) {
			return;
		}
		result.add(node.val);
		if (null != node.children) {
			for (Node n : node.children) {
				helper(n, result);
			}
		}
	}

	public static void main(String[] args) {
		NAryTreePreorderTraversal a = new NAryTreePreorderTraversal();
		Node node5 = new NAryTreePreorderTraversal().new Node(5, null);
		Node node6 = new NAryTreePreorderTraversal().new Node(6, null);
		Node node3 = new NAryTreePreorderTraversal().new Node(3, Arrays.asList(node5, node6));
		Node node2 = new NAryTreePreorderTraversal().new Node(2, null);
		Node node4 = new NAryTreePreorderTraversal().new Node(4, null);
		Node node1 = new NAryTreePreorderTraversal().new Node(1, Arrays.asList(node3, node2, node4));

		System.out.println(a.preorder(node1));

	}
}
