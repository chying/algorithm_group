package algorithm.chapter2.template;

import java.util.List;

/**
 * ��N�����ı���������һ�� N ������������ڵ�ֵ�ĺ��������
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 
 * @author chying
 *
 */
public class NAryTreeTraversal {

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
		return null;
	}

	public List<Integer> postorder(Node root) {
		return null;
	}

}
