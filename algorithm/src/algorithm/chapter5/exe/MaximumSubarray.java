package algorithm.chapter5.exe;

/**
 * 【53. 最大子序和】给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 示例: 输入:
 * [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶: 如果你已经实现复杂度为
 * O(n) 的解法，尝试使用更为精妙的分治法求解。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums != null && nums.length > 0) {
			int[] dp = new int[nums.length];
			dp[0] = Math.max(nums[0], 0);
			int max = dp[0];
			for (int i = 1; i < nums.length; i++) {
				dp[i] = Math.max(dp[i - 1], 0) + nums[i];
				max = Math.max(max, dp[i]);
			}
			return max;
		}
		return 0;
	}

	public static void main(String[] args) {
		MaximumSubarray a = new MaximumSubarray();
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println(a.maxSubArray(nums));
	}
}
