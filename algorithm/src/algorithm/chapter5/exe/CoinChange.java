package algorithm.chapter5.exe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

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
		if (null != coins) {
			int[] dp = new int[amount + 1];
			Arrays.fill(dp, amount + 1);
			dp[0] = 0;
			for (int i = 1; i <= amount; i++) {
				for (int coin : coins) {
					if (i - coin >= 0) {
						dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
					}
				}
			}
			return dp[amount] < amount + 1 ? dp[amount] : -1;
		}
		return -1;
	}

	public static void main(String[] args) {
		CoinChange a = new CoinChange();
		int[] coins = new int[] { 1, 2, 5 };
		System.out.println(a.coinChange(coins, 11));
	}

	/**
	 * 超出内存限制
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange_BFS(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		if (null != coins) {
			Deque<Integer> deque = new ArrayDeque<Integer>();
			deque.addFirst(amount);
			Set<Integer> visitedSet = new HashSet<>();
			int res = 0;
			while (!deque.isEmpty()) {
				int size = deque.size();
				res++;
				for (int i = 0; i < size; i++) {
					int val = deque.pollLast();
					for (int coin : coins) {
						int value = val - coin;
						if (value == 0) {
							return res;
						} else if (value > 0 && !visitedSet.contains(value)) {
							visitedSet.add(value);
							deque.addFirst(value);
						}
					}
				}
			}
		}
		return 0;
	}
}
