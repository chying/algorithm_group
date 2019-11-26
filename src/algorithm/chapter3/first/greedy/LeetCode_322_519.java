package algorithm.chapter3.first.greedy;

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
public class LeetCode_322_519 {
	
	int total = Integer.MAX_VALUE;

	public int coinChange(int[] coins, int amount) {
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

	public static void main(String[] args) {
		LeetCode_322_519 a = new LeetCode_322_519();
		int[] coins = new int[] { 1, 2, 5 };
//		coins = [2], amount = 3
//		[186,419,83,408]6249

//		int[] coins = new int[] { 186, 419, 83, 408 };
		System.out.println(a.coinChange(coins, 11));
	}
}
