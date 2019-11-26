package algorithm.chapter1.template;

/**
 * 【滑动窗口最大值】 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的
 * k 个数字。滑动窗口每次只向右移动一位。 返回滑动窗口中的最大值。 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出:
 * [3,3,5,5,6,7] 解释: 滑窗口的位置 最大值 --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3
 * -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3
 * 6] 7 6 1 3 -1 -3 5 [3 6 7] 7   提示： 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k
 * ≤ 输入数组的大小。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 
 * @author chying
 *
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum a = new SlidingWindowMaximum();
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		a.maxSlidingWindow(nums, k);
	}
}
