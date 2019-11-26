package algorithm.chapter4.template;

/***
 * 【123. 买卖股票的最佳时机】给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 示例 1:
 * 输入: [3,3,5,0,0,3,1,4] 输出: 6 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 =
 * 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。   随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 =
 * 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockiii {
	public int maxProfit(int[] prices) {
		if (null != prices) {
			int len = prices.length;
			// dp利润 k=2次交易
			int[][][] dp = new int[len][2][2];
			
			dp[0][0][0] = 0;
			dp[0][0][1] = -prices[0];

			dp[0][1][0] = 0;
			dp[0][1][1] = 0;

			for (int i = 1; i < len; i++) {
//				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//				dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			}
			return Math.max(dp[len - 1][0][0], dp[len - 1][1][0]);
		}
		return 0;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockiii a = new BestTimeToBuyAndSellStockiii();
		int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(a.maxProfit(prices));
	}
}
