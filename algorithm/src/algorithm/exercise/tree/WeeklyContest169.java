package algorithm.exercise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class WeeklyContest169 {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> result = new ArrayList<>();
		if (root1 == null && root2 == null) {
			return result;
		}
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		inOrderTree(root1, list1);
		inOrderTree(root2, list2);
		list1.size();
		int i = 0, j = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) >= list2.get(j)) {
				result.add(list2.get(j));
				j++;
			} else {
				result.add(list1.get(i));
				i++;
			}
		}
		while (i < list1.size()) {
			result.add(list1.get(i++));
		}
		while (j < list2.size()) {
			result.add(list2.get(j++));
		}
		return result;
	}

	private void inOrderTree(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}

		inOrderTree(node.left, list);
		list.add(node.val);
		inOrderTree(node.right, list);
		return;
	}

	public static void main(String[] args) {
		WeeklyContest169 a = new WeeklyContest169();
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;

		TreeNode node21 = new TreeNode(1);
		TreeNode node22 = new TreeNode(0);
		TreeNode node23 = new TreeNode(3);
		node21.left = node22;
		node21.right = node23;

		List<Integer> list1 = new ArrayList<>();
		list1 = a.getAllElements(node1, node21);
		System.out.println(list1.toString());
	}
}
