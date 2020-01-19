package algorithm.exercise.tree.exe;

import java.util.HashMap;
import java.util.Map;

/**
 * 【】
 * 
 * @author chying
 *
 */
public class TreePratices {
	/**
	 * 根据一棵树的中序遍历与后序遍历构造二叉树
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree_p(int[] inorder, int[] postorder) {
		if (null != inorder && null != postorder) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < inorder.length; i++) {
				map.put(inorder[i], i);
			}
			return helper_p(postorder.length - 1, map, 0, postorder.length - 1, postorder);
		}
		return null;
	}

	private TreeNode helper_p(int postStart, Map<Integer, Integer> map, int begin, int end, int[] postorder) {
		if (begin > end || begin < 0 || end > postorder.length) {
			return null;
		}
		TreeNode node = new TreeNode(postorder[postStart]);
		node.left = helper_p(postStart, map, begin, map.get(postorder[postStart]) - 1, postorder);
		node.right = helper_p(postStart, map, map.get(postorder[postStart]) + 1, end - 1, postorder);
		return node;
	}

	/**
	 * 根据一棵树的前序遍历与中序遍历构造二叉树。
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree_r(int[] preorder, int[] inorder) {
		return null;
	}

	public static void main(String[] args) {
		TreePratices a = new TreePratices();
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		int[] postorder = new int[] { 9, 15, 7, 20, 3 };
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
//		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		a.buildTree_p(inorder, postorder);
//		a.buildTree_r(preorder, inorder);

	}
}
