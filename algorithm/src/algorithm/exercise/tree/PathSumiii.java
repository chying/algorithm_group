package algorithm.exercise.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ¡¾437. Â·¾¶×ÜºÍ III¡¿
 * 
 * @author chying
 *
 */
public class PathSumiii {
	private int result = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root != null) {
			helper(root, sum, new ArrayList<TreeNode>());
		}
		return result;
	}

	private void helper(TreeNode node, int sum, List<TreeNode> list) {
		if (node == null) {
			return;
		}

		if (node.val > sum) {
			helper(node.left, sum, new ArrayList<TreeNode>());
			helper(node.right, sum, new ArrayList<TreeNode>());
		} else if (node.val == sum) {
			if (list.size() > 0) {
				result++;
			}
		} else {
			list.add(node);
			helper(node.left, sum - node.val, list);
			helper(node.right, sum - node.val, list);
		}
	}

	public static void main(String[] args) {
		PathSumiii a = new PathSumiii();
		TreeNode root = new TreeNode(10);
		TreeNode node9 = new TreeNode(5);
		TreeNode node20 = new TreeNode(-3);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
//		node3.left = node9;
//		node3.right = node20;
//		node20.left = node15;
//		node20.right = node7;
	}
}
