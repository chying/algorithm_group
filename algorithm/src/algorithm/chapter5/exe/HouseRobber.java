package algorithm.chapter5.exe;

/**
 * 【198.
 * 打家劫舍】你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 示例 1: 输入: [1,2,3,1] 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。   偷窃到的最高金额 = 1 + 3 = 4 。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// 0 第i天不偷， 1 第i天偷
		int[][] dp = new int[nums.length][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = dp[i - 1][0] + nums[i];
		}
		return Math.max(dp[nums.length - 1][1], dp[nums.length - 2][1]);
	}

	public static void main(String[] args) {
		HouseRobber a = new HouseRobber();
		int[] nums = new int[] { 5, 2, 1, 3 };
		System.out.println(a.rob(nums));
	}

	public int rob_compress(int[] nums) {

		if (nums != null) {
			int len = nums.length;
			if (len == 0)
				return 0;
			if (len == 1)
				return nums[0];
			int[] a = new int[nums.length];
			a[0] = nums[0];
			a[1] = Math.max(a[0], nums[1]);
			int res = Math.max(a[0], nums[1]);
			for (int i = 2; i < nums.length; i++) {
				a[i] = Math.max(a[i - 1], a[i - 2] + nums[i]);
			}
			res = Math.max(a[nums.length - 1], a[nums.length - 2]);
			return res;
		}
		return 0;

	}
}
