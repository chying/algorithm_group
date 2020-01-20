package algorithm.exercise.greecy;

import java.util.Arrays;

public class CoinChange {
	/**
	 * º«“‰ªØ
	 * 
	 * @param nums
	 * @param total
	 * @return
	 */

	public int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		return coinChange(coins, amount, new int[amount]);
	}

	private int coinChange(int[] coins, int rem, int[] count) {
		if (rem < 0)
			return -1;
		if (rem == 0)
			return 0;
		if (count[rem - 1] != 0)
			return count[rem - 1];
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, rem - coin, count);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}

	public static void main(String[] args) {
		CoinChange a = new CoinChange();
		int[] nums = new int[] { 1, 2, 5 };
		int target = 11;
		System.out.println(a.coinChange2(nums, target));
	}

	public int coinChange1(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
				}
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

	public int coinChange2(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}
