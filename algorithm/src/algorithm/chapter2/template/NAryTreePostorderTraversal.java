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
public class NAryTreePostorderTraversal {
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
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			if (null != root.children && root.children.size() > 0) {
				postorder_helper(root.children, result);
			}
			result.add(root.val);
		}
		return result;
	}

	private void postorder_helper(List<Node> children, List<Integer> result) {
		if (children == null) {
			return;
		}
		for (Node node : children) {
			postorder_helper(node.children, result);
			result.add(node.val);
		}
	}

	public static void main(String[] args) {
		NAryTreePostorderTraversal a = new NAryTreePostorderTraversal();
		Node node5 = new NAryTreePostorderTraversal().new Node(5, null);
		Node node6 = new NAryTreePostorderTraversal().new Node(6, null);
		Node node3 = new NAryTreePostorderTraversal().new Node(3, Arrays.asList(node5, node6));
		Node node2 = new NAryTreePostorderTraversal().new Node(2, null);
		Node node4 = new NAryTreePostorderTraversal().new Node(4, null);
		Node node1 = new NAryTreePostorderTraversal().new Node(1, Arrays.asList(node3, node2, node4));

		System.out.println(a.postorder(node1));

	}
}
