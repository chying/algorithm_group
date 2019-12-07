package algorithm.chapter8.first.dp;

import java.util.Arrays;

/**
 * 【300. 最长上升子序列】给定一个无序的整数数组，找到其中最长上升子序列的长度。 示例: 输入: [10,9,2,5,3,7,101,18] 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		int res = 0;
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	/**
	 * DP+二分查找 执行用时 : 1 ms , 在所有 java 提交中击败了 97.99% 的用户 内存消耗 : 35.7 MB , 在所有 java
	 * 提交中击败了 35.57% 的用户
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS1(int[] nums) {
		int[] tails = new int[nums.length];
		int res = 0;
		for (int num : nums) {
			int i = 0, j = res;
			while (i < j) {
				int m = (i + j) / 2;
				if (tails[m] < num)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = num;
			if (res == j)
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence a = new LongestIncreasingSubsequence();
		int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(a.lengthOfLIS_text(nums));
	}

	public int lengthOfLIS_text(int[] nums) {
		if (null != nums) {
			int[] dp = new int[nums.length];
			Arrays.fill(dp, 1);
			for (int i = 1; i < nums.length; i++) {
				for (int j = 0; j < i; j++) {
					if (nums[i] > nums[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
			return dp[nums.length - 1];
		}
		return 0;
	}
}
