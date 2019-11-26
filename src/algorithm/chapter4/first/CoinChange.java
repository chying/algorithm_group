package algorithm.chapter4.first;

import java.util.Arrays;

/**
 * 【322. 零钱兑换】给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。 示例 1: 输入: coins =
 * [1, 2, 5], amount = 11 输出: 3 解释: 11 = 5 + 5 + 1 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount <= 0)
			return 0;
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
			}
		}
		if (dp[amount] == Integer.MAX_VALUE)
			return -1;
		else
			return dp[amount];
	}

	public static void main(String[] args) {
		CoinChange a = new CoinChange();
		int[] coins = new int[] { 1, 2, 5 };
		System.out.println(a.coinChange(coins, 11));
	}

	public int coinChange1(int[] coins, int amount) {
		if (null != coins) {
			Arrays.sort(coins);
			for (int i = 0; i < amount; i++) {
				for (int num : coins) {

				}
			}
		}
		return 0;
	}
}
