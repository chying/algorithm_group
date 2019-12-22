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
		if (null != nums && nums.length > 0) {
			int len = nums.length;

			TreeNode node = new TreeNode(nums[len / 2]);
			buildTree(node, 0, len - 1);
			node.left = new TreeNode(nums[len / 4]);
			node.right = new TreeNode(nums[len / 4]);
			return node;
		}
		return null;
	}

	private void buildTree(TreeNode node, int start, int end) {
		if (start > end) {
			return;
		}
//		node.left=buildTree(node,);

	}

	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree a = new ConvertSortedArrayToBinarySearchTree();
		int[] nums = new int[] { -10, -3, 0, 5, 9 };
		a.sortedArrayToBST(nums);
	}

}
