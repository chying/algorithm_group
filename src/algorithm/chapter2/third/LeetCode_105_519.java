package algorithm.chapter2.third;

import java.util.HashMap;
import java.util.Map;

/**
 * 【105. 从前序与中序遍历序列构造二叉树】根据一棵树的前序遍历与中序遍历构造二叉树。 注意: 你可以假设树中没有重复的元素。 例如，给出 前序遍历
 * preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 
 * @author chying
 *
 */
public class LeetCode_105_519 {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder != null && inorder != null) {
			Map<Integer, Integer> inMap = new HashMap<>();
			for (int i = 0; i < inorder.length; i++) {
				inMap.put(inorder[i], i);
			}
			TreeNode node = buildTree(0, 0, inorder.length - 1, preorder, inMap);
			return node;
		}
		return null;
	}

	private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> inMap) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[preStart]);
		int index = inMap.get(preorder[preStart]);
		int numsLeft = index - inStart;
		node.left = buildTree(preStart + 1, 0, index - 1, preorder, inMap);
		node.right = buildTree(preStart + numsLeft + 1, index + 1, inEnd, preorder, inMap);
		return node;

	}

	public static void main(String[] args) {
		LeetCode_105_519 a = new LeetCode_105_519();
		int[] preorder = new int[] { 1, 2, 4, 8, 5, 3, 6, 7 };
		int[] inorder = new int[]  { 8, 4, 2, 5, 1, 6, 3, 7 };

		a.buildTree(preorder, inorder);
	}
}
