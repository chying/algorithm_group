package algorithm.exercise.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ¡¾100. ÏàÍ¬µÄÊ÷¡¿ https://leetcode-cn.com/problems/same-tree/
 * 
 * @author chying
 *
 */
public class SameTree {

	public static void main(String[] args) {
		SameTree a = new SameTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(1);
		node1.left = node2;
//		node1.right = node3;
		TreeNode node21 = new TreeNode(1);
//		TreeNode node22 = new TreeNode(1);
		TreeNode node23 = new TreeNode(2);
//		node21.left = node22;
		node21.right = node23;
		System.out.println(a.isSameTree(node1, node21));
	}

	public boolean isSameTree_1(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			if (p.val == q.val) {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
			return false;
		}
		if (p == null && q == null) {
			return true;
		}
		return false;
	}
}
