package algorithm.chapter2.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 【给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。】 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 
 * @author chying
 *
 */
public class NAryTreeLevelOrderTraversal {

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

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> nodelist = new ArrayList<>();
		getNodeList(result, nodelist, root);
		return result;
	}

	private List<Integer> getNodeList(List<List<Integer>> result, List<Integer> nodelist, Node node) {
		if (node.children == null) {
			nodelist.add(node.val);
			return nodelist;
		} else {
			for (Node n : node.children) {
				getNodeList(result, nodelist, n);
			}
			result.add(new ArrayList<>(nodelist));
		}

		return null;
	}

	public static void main(String[] args) {
		NAryTreeLevelOrderTraversal a = new NAryTreeLevelOrderTraversal();
		Node child_5 = new NAryTreeLevelOrderTraversal().new Node(5, null);
		Node child_6 = new NAryTreeLevelOrderTraversal().new Node(6, null);
		List<Node> list1 = new ArrayList<>();
		list1.add(child_5);
		list1.add(child_6);
		Node child_3 = new NAryTreeLevelOrderTraversal().new Node(3, list1);
		Node child_2 = new NAryTreeLevelOrderTraversal().new Node(2, null);
		Node child_4 = new NAryTreeLevelOrderTraversal().new Node(4, null);
		List<Node> list2 = new ArrayList<>();
		list2.add(child_3);
		list2.add(child_2);
		list2.add(child_4);
		Node root = new NAryTreeLevelOrderTraversal().new Node(1, list2);
		List<List<Integer>> result = a.levelOrder(root);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
