package algorithm.exercise.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 【113. 路径总和 II】
 * 
 * @author chying
 *
 */
public class PathSumii {
	public List<List<Integer>> pathSum22(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();
		helper(root, sum, res, subList);
		return res;
	}

	private void helper(TreeNode node, int sum, List<List<Integer>> res, List<Integer> subList) {
		if (node == null) {
			return;
		}
		subList.add(node.val);
		sum -= node.val;
		if (node.left == null && node.right == null) {
			if (0 == sum) {
				res.add(new ArrayList<>(subList));
			}
		} else {
			helper(node.left, sum, res, subList);
			helper(node.right, sum, res, subList);
		}
		subList.remove(subList.size() - 1);
	}

	public static void main(String[] args) {
		PathSumii a = new PathSumii();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		List<List<Integer>> res = a.pathSum22(root, 22);
		for (List<Integer> list : res) {
			System.out.println(list.toString());
		}
	}

	List<List<Integer>> list = new ArrayList<>();
	ArrayList<Integer> inner = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return list;
		sum -= root.val;
		inner.add(root.val); // 入列表
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				list.add(new ArrayList<>(inner)); // 记得拷贝一份
			}

		}
		if (root.left != null)
			pathSum(root.left, sum);
		if (root.right != null)
			pathSum(root.right, sum);
		inner.remove(inner.size() - 1); // 从列表中删除
		return list;
	}

}
