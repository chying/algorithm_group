package algorithm.chapter2.template;

import java.util.HashMap;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。 注意: 你可以假设树中没有重复的元素。 例如，给出 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3] 返回如下的二叉树：
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 
 * @author chying
 *
 */
public class LeetCode_106_519 {
//	public TreeNode buildTree(int[] inorder, int[] postorder) {
//		HashMap<Integer, Integer> inMap = new HashMap<>();
//		for (int i = 0; i < inorder.length; i++) {
//			inMap.put(inorder[i], i);
//		}
//		return buildNode(postorder.length - 1, 0, inorder.length - 1, postorder, inMap);
//	}
//
//	private TreeNode buildNode(int postStart, int inStart, int inEnd, int[] postorder,
//			HashMap<Integer, Integer> inMap) {
//		if (postStart < 0 || inStart > inEnd) {
//			return null;
//		}
//		TreeNode node = new TreeNode(postorder[postStart]);
//		int inIndex = inMap.get(postorder[postStart]);
//		int numsRight = postorder.length - inIndex - 1;
//		node.right = buildNode(postStart - 1, inIndex + 1, inEnd, postorder, inMap);
//		node.left = buildNode(postStart - numsRight - 1, inStart, inIndex - 1, postorder, inMap);
//		return node;
//	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree1(int[] inorder, int[] post) {
		if (inorder == null || inorder.length == 0 || post == null || post.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return helper(post.length - 1, 0, inorder.length - 1, post, inMap);
	}

	private TreeNode helper(int postStart, int start, int end, int[] post, HashMap<Integer, Integer> inMap) {
		if (start > end || postStart < 0) {
			return null;
		}
		TreeNode root = new TreeNode(post[postStart]);
		int index = inMap.get(post[postStart]);

		root.right = helper(postStart - 1, index + 1, end, post, inMap);
		root.left = helper(postStart - (end - index + 1), start, index - 1, post, inMap);
		return root;
	}

}
