package algorithm.february.dp;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 
 * @author chying
 *
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		if (prices != null && prices.length > 1) {
			int len = prices.length;
			for (int i = 1; i < len; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (prices[i] > prices[j]) {
						maxProfit = Math.max(prices[i] - prices[j], maxProfit);
					}
				}
			}
		}

		return maxProfit;
	}

	public int maxProfit_dp(int[] prices) {
		int maxProfit = 0;
		if (prices != null && prices.length > 1) {
			int len = prices.length;
			int[][] dp = new int[len][2];
			dp[0][0] = 0;
			dp[0][1] = -prices[0];
			for (int i = 1; i < len; i++) {
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
				dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
			}
			return dp[len - 1][0];
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock a = new BestTimeToBuyAndSellStock();
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(a.maxProfit_dp_compress(prices));
	}

	public int maxProfit_dp_compress(int[] prices) {
		int maxProfit = 0;
		if (prices != null && prices.length > 1) {
			int len = prices.length;
			int sell = 0, buy = -prices[0];
			for (int i = 1; i < len; i++) {
				sell = Math.max(sell, buy + prices[i]);
				buy = Math.max(buy, -prices[i]);
			}
			return sell;
		}
		return maxProfit;
	}
}
