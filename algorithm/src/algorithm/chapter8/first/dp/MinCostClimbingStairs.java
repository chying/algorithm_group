package algorithm.chapter8.first.dp;

/**
 * 【746. 使用�?小花费爬楼梯】数组的每个索引做为�?个阶梯，第 i个阶梯对应着�?个非负数的体力花费�?� cost[i](索引�?0�?�?)�?
 * 每当你爬上一个阶梯你都要花费对应的体力花费�?�，然后你可以�?�择继续爬一个阶梯或者爬两个阶梯�?
 * 您需要找到达到楼层顶部的�?低花费�?�在�?始时，你可以选择从索引为 0 �? 1 的元素作为初始阶梯�?? 示例 1: 输入: cost = [10,
 * 15, 20] 输出: 15 解释: �?低花费是从cost[1]�?始，然后走两步即可到阶梯顶，�?共花�?15�? 来源：力扣（LeetCode�?
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
 * 
 * @author chying
 *
 */
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		if (null != cost) {
			int[] dp = new int[cost.length];
			dp[0] = cost[0];
			dp[1] = cost[1];
			for (int i = 2; i < cost.length; i++) {
				dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
			}
			return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
		}
		return 0;
	}

	public static void main(String[] args) {
		MinCostClimbingStairs a = new MinCostClimbingStairs();
		int[] cost = new int[] { 10, 15, 20 };
		System.out.println(a.minCostClimbingStairs(cost));
	}
}
