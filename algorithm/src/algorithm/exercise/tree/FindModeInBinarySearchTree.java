package algorithm.exercise.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【501. 二叉搜索树中的众数】
 * 
 * @author chying
 *
 */
public class FindModeInBinarySearchTree {

	public int[] findMode(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		if (null != root) {
			helper(root, list);
			int count_max = 1;
			int temp = list.get(0);
			int count_temp = 1;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) != temp) {
					if (count_max == count_temp) {
						result.add(temp);
					} else if (count_max < count_temp) {
						result.clear();
						result.add(temp);
						count_max = count_temp;
					}
					temp = list.get(i);
					count_temp = 1;
				} else {
					count_temp++;
				}
			}
			if (count_max == count_temp) {
				result.add(temp);
			} else if (count_max < count_temp) {
				result.clear();
				result.add(temp);
				count_max = count_temp;
			}
		}
		int[] newRes = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			newRes[i] = result.get(i);
		}
		return newRes;
	}

	private void helper(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		helper(node.left, list);
		list.add(node.val);
		helper(node.right, list);
	}

	public static void main(String[] args) {
		FindModeInBinarySearchTree a = new FindModeInBinarySearchTree();
		TreeNode root = new TreeNode(1);
		TreeNode node11 = new TreeNode(2);
		TreeNode node12 = new TreeNode(2);
		root.right = node11;
		node11.right = node12;
		System.out.println(Arrays.toString(a.findMode(root)));

	}

	private int currVal;
	private int currCount = 0;
	private int maxCount = 0;
	private int modeCount = 0;

	private int[] modes;

	public int[] findMode_1(TreeNode root) {
		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inorder(root);
		return modes;
	}

	private void handleValue(int val) {
		if (val != currVal) {
			currVal = val;
			currCount = 0;
		}
		currCount++;
		if (currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		} else if (currCount == maxCount) {
			if (modes != null)
				modes[modeCount] = currVal;
			modeCount++;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}
}
