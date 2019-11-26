package algorithm.chapter2.first;

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
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//	Map<Integer, Integer> inMap = new HashMap<>();
//	for (int i = 0; i < inorder.length; i++) {
//		inMap.put(inorder[i], i);
//	}
//	return buildNode(0, 0, inorder.length - 1, preorder, inorder, inMap);
//
//}
//
//private TreeNode buildNode(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,
//		Map<Integer, Integer> inMap) {
//	if (preStart > preorder.length - 1 || inStart > inEnd) {
//		return null;
//	}
//	TreeNode root = new TreeNode(preorder[preStart]);
//	int inIndex = inMap.get(preorder[preStart]);
//	root.left = buildNode(preStart + 1, inStart, inIndex - 1, preorder, inorder, inMap);
//	root.right = buildNode(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, inMap);
//	return root;
//}
//
//public TreeNode buildTree1(int[] preorder, int[] inorder) {
//	Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
//
//	for (int i = 0; i < inorder.length; i++) {
//		inMap.put(inorder[i], i);
//	}
//
//	TreeNode root = buildTree(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, inMap);
//	return root;
//}
//
//public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder,
//		Map<Integer, Integer> inMap) {
//	if (preStart > preEnd || inStart > inEnd)
//		return null;
//
//	TreeNode root = new TreeNode(preorder[preStart]);
//	int inIndex = inMap.get(root.val);
//	int numsLeft = inIndex - inStart;
//
//	root.left = buildTree(preStart + 1, preStart + numsLeft, inStart, inIndex - 1, preorder, inorder, inMap);
//	root.right = buildTree(preStart + numsLeft + 1, preEnd, inIndex + 1, inEnd, preorder, inorder, inMap);
//
//	return root;
//}
//
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}

	public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	    if(preStart > preEnd || inStart > inEnd) return null;

	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;

	    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

	    return root;
	}

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		LeetCode_105_519 a = new LeetCode_105_519();
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		a.buildTree(preorder, inorder);
	}
}
