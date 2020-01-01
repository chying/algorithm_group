package algorithm.exercise.tree;

/**
 * 【108. 将有序数组转换为二叉搜索树】
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
	 * 类似二分查找
	 * 
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
//		if (null != nums && nums.length > 0) {
//			int len = nums.length;
//			TreeNode node = new TreeNode(nums[len / 2]);
//			node.left = buildTree(nums, 0, len / 2);
//			node.right = buildTree(nums, len / 2, len);
//			return node;
//		}
		return null;
	}

	private TreeNode buildTree(int[] nums, int start, int mid, int end) {
		if (start > end) {
			return null;
		}
		TreeNode node = new TreeNode(nums[(end - start) / 2]);
		start = 0;
//		int mid = (end - start) / 2;
//		node.left = buildTree(nums, start, mid);
//		node.right = buildTree(nums, len / 2, len);
		return node;

	}

	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree a = new ConvertSortedArrayToBinarySearchTree();
		int[] nums = new int[] { -10, -3, 0, 5, 9 };
		a.sortedArrayToBST(nums);
	}

}
