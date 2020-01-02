package algorithm.exercise.tree;

/**
 * ��108. ����������ת��Ϊ������������
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * @author chying
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * ���ƶ��ֲ���
	 * 
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (null != nums && nums.length > 0) {
			return buildTree(nums, 0, nums.length - 1);
		}
		return null;
	}

	private TreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = buildTree(nums, start, mid - 1);
		node.right = buildTree(nums, mid + 1, end);
		return node;
	}

	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree a = new ConvertSortedArrayToBinarySearchTree();
		int[] nums = new int[] { -10, -3, 0, 5, 9 };
		TreeNode node = a.sortedArrayToBST(nums);

		System.out.println(node);
	}

}
