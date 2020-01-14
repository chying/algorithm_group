package algorithm.exercise.a;

import java.util.ArrayList;
import java.util.List;

public class ValidBFSTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;

		int val = node.val;
		if (lower != null && val <= lower)
			return false;
		if (upper != null && val >= upper)
			return false;

		if (!helper(node.left, lower, val))
			return false;
		if (!helper(node.right, val, upper))
			return false;

		return true;
	}

	public static void main(String[] args) {
		ValidBFSTree a = new ValidBFSTree();
		TreeNode node3 = a.new TreeNode(10);
		TreeNode node9 = a.new TreeNode(5);
		TreeNode node20 = a.new TreeNode(15);
		TreeNode node15 = a.new TreeNode(6);
		TreeNode node7 = a.new TreeNode(20);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
//		[5,1,4,null,null,3,6]
//		[10,5,15,null,null,6,20]
		System.out.println(a.isValidBST_2(node3));
	}

	List<Integer> list = new ArrayList<>();

	boolean isValidBST_inorder(TreeNode root) {
		helper(root);
		int prev = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				prev = list.get(i);
				continue;
			}
			if (prev >= list.get(i)) {
				return false;
			}
			prev = list.get(i);
		}
		return true;
	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			helper(root.left);
		}
		list.add(root.val);
		if (root.right != null) {
			helper(root.right);
		}
	}

	public boolean isValidBST_2(TreeNode root) {
		return helper1(root, null, null);
	}

	private boolean helper1(TreeNode node, Integer down, Integer up) {
		if (node == null) {
			return true;
		}
		int val = node.val;
		if (down != null && val <= down) {
			return false;
		}
		if (up != null && val >= up) {
			return false;
		}
		if (!helper1(node.left, down, val)) {
			return false;
		}
		if (!helper1(node.right, val, up)) {
			return false;
		}

		return true;
	}

}
