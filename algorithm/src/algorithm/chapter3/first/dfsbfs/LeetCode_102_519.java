package algorithm.chapter3.first.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class LeetCode_102_519 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int cnt = queue.size();
			for (int i = 0; i < cnt; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(level);
		}
		return res;
	}

	public static void main(String[] args) {
		LeetCode_102_519 a = new LeetCode_102_519();
		TreeNode node_3 = new LeetCode_102_519().new TreeNode(3);
		TreeNode node_9 = new LeetCode_102_519().new TreeNode(9);
		TreeNode node_20 = new LeetCode_102_519().new TreeNode(20);
		TreeNode node_15 = new LeetCode_102_519().new TreeNode(15);
		TreeNode node_7 = new LeetCode_102_519().new TreeNode(7);
		node_3.left = node_9;
		node_3.right = node_20;
		node_20.left = node_15;
		node_20.right = node_7;
		List<List<Integer>> result = a.levelOrder(node_3);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
