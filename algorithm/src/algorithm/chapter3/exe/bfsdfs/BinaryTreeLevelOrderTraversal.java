package algorithm.chapter3.exe.bfsdfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 【102. 二叉树的层次遍历】 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 例如:
 * 给定二叉树: [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15 7 返回其层次遍历结果： [ [3], [9,20],
 * [15,7] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		if (root != null) {
			queue.add(root);
			while (queue != null && queue.size() > 0) {
				List<Integer> subList = new ArrayList<>();
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.pollFirst();
					subList.add(node.val);
					if (node.left != null) {
						queue.addLast(node.left);
					}
					if (node.right != null) {
						queue.addLast(node.right);
					}
				}
				result.add(subList);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal a = new BinaryTreeLevelOrderTraversal();
		TreeNode node_3 = new BinaryTreeLevelOrderTraversal().new TreeNode(3);
		TreeNode node_9 = new BinaryTreeLevelOrderTraversal().new TreeNode(9);
		TreeNode node_20 = new BinaryTreeLevelOrderTraversal().new TreeNode(20);
		TreeNode node_15 = new BinaryTreeLevelOrderTraversal().new TreeNode(15);
		TreeNode node_7 = new BinaryTreeLevelOrderTraversal().new TreeNode(7);
		node_3.left = node_9;
		node_3.right = node_20;
		node_20.left = node_15;
		node_20.right = node_7;
		List<List<Integer>> result = a.levelOrder1(node_3);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}

	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (null != root) {
			Deque<TreeNode> deque = new ArrayDeque<>();
			deque.add(root);
			while (null != deque && !deque.isEmpty()) {
				int size = deque.size();
				List<Integer> subList = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollLast();
					subList.add(node.val);
					if (node.left != null) {
						deque.addFirst(node.left);
					}
					if (node.right != null) {
						deque.addFirst(node.right);
					}
				}
				result.add(subList);
			}
		}
		return result;
	}
}
