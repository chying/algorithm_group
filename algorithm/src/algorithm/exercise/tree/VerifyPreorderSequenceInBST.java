package algorithm.exercise.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 【255. 验证前序遍历序列二叉搜索树】
 * https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/
 * 
 * @author chying
 *
 */
public class VerifyPreorderSequenceInBST {
	public boolean verifyPreorder(int[] preorder) {
		if (null != preorder) {
			return helper(preorder, 0, preorder.length - 1);
		}
		return false;
	}

	private boolean helper(int[] preorder, int start, int end) {
		if (start >= end) {
			return true;
		}
		int root = preorder[start];
		boolean right = false;
		int lb = start;
		int rb = start;
		for (int i = start + 1; i < preorder.length; i++) {
			if (root < preorder[i] && !right) {
				lb = i - 1;
				rb = i;
				right = !right;
			}
			if (right && root > preorder[i]) {
				return false;
			}
		}

		return helper(preorder, start + 1, rb - 1) && helper(preorder, rb, end);
	}

	public static void main(String[] args) {
		VerifyPreorderSequenceInBST a = new VerifyPreorderSequenceInBST();
		int[] preorder = new int[] { 6, 4, 5, 2, 7, 8 };
		System.out.println(a.verifyPreorder_3(preorder));
	}

	public boolean verifyPreorder_2(int[] preorder) {
		if (null != preorder) {
			Deque<Integer> deque = new ArrayDeque<>();
			int min = Integer.MIN_VALUE;
			for (int i = 0; i < preorder.length; i++) {
				if (min > preorder[i]) {
					return false;
				}
				while (!deque.isEmpty() && preorder[i] > deque.peekFirst()) {
					min = deque.pollFirst();
				}
				deque.push(preorder[i]);
			}
			return true;
		}
		return false;
	}

	public boolean verifyPreorder_3(int[] preorder) {
		if (null != preorder) {
			int[] stack = new int[preorder.length];
			int size = 0;
			int min = Integer.MIN_VALUE;
			for (int i = 0; i < preorder.length; i++) {
				if (min > preorder[i]) {
					return false;
				}
				// 到了右子树
				while (size != 0 && preorder[i] > stack[size - 1]) {
					min = stack[size - 1];
					size--;
				}
				stack[size++] = preorder[i];
			}
		}
		return true;
	}

}
