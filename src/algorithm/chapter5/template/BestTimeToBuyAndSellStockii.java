package algorithm.chapter5.template;

/**
 * 【122. 买卖股票的最佳时机 II】给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 示例 1: 输入: [7,1,5,3,6,4] 输出: 7 解释: 在第 2
 * 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   随后，在第 4
 * 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class BestTimeToBuyAndSellStockii {
	/**
	 * dp方程
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (null != prices) {
			int len = prices.length;
			// dp利润
			int[][] dp = new int[len][2];
			// 卖出
			dp[0][0] = 0;
			// 买入
			dp[0][1] = -prices[0];
			for (int i = 1; i < len; i++) {
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
				dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			}
			return dp[len - 1][0];
		}
		return 0;
	}

	public int maxProfit_greedy(int[] prices) {
		int maxProfit = 0;
		if (null != prices) {
			int len = prices.length;
			if (prices.length > 1) {
				for (int i = 1; i < len; i++) {
					if (prices[i] - prices[i - 1] > 0) {
						maxProfit += prices[i] - prices[i - 1];
					}
				}
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockii a = new BestTimeToBuyAndSellStockii();
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(a.maxProfit(prices));
	}
}
