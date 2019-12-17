package algorithm.chapter3.exe.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
	/**
	 * BFS ==0 的层数 超出内存限制
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if (null != coins && coins.length > 0 && amount > 0) {
			Deque<Integer> deque = new ArrayDeque<>();
			deque.addFirst(amount);
			int count = 0;
			while (!deque.isEmpty()) {
				count++;
				int size = deque.size();
				for (int i = 0; i < size; i++) {
					int val = deque.pollLast();
					for (int coin : coins) {
						int newVal = val - coin;
						if (newVal == 0) {
							return count;
						} else if (newVal > 0) {
							deque.addFirst(newVal);
						}
					}
				}
			}
			return -1;
		}

		return -1;
	}

	public static void main(String[] args) {
		CoinChange a = new CoinChange();
		int[] coins = new int[] { 186, 419, 83, 408 };
		int amount = 6249;
		System.out.println(a.coinChange_greey(coins, amount));
	}

	public int coinChange_greey(int[] coins, int amount) {
		if (null != coins && coins.length > 0 && amount > 0) {
			Arrays.sort(coins);
			int count = 0;
			for (int i = coins.length - 1; i >= 0; i--) {
				if (amount == 0) {
					return count;
				}
				int n = amount / coins[i];
				count += n;
				amount = amount % coins[i];
			}
			if (amount == 0) {
				return count;
			} else {
				return -1;
			}
		}

		return 0;
	}

	int total = Integer.MAX_VALUE;

	public int coinChange1(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		Arrays.sort(coins);
		count(amount, coins.length - 1, coins, 0);
		return total == Integer.MAX_VALUE ? -1 : total;
	}

	void count(int amount, int index, int[] coins, int count) {
		if (index < 0 || count >= total - 1)
			return;
		int c = amount / coins[index];
		for (int i = c; i >= 0; i--) {
			int newCount = count + i;
			int rem = amount - i * coins[index];
			if (rem > 0 && newCount < total)
				count(rem, index - 1, coins, newCount);
			else if (newCount < total)
				total = newCount;
			else if (newCount >= total - 1)
				break;
		}
	}
}
