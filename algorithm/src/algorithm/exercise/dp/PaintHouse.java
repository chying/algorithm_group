package algorithm.exercise.dp;

/**
 * ¡¾256. ·ÛË¢·¿×Ó¡¿ https://leetcode-cn.com/problems/paint-house/
 * 
 * @author chying
 *
 */
public class PaintHouse {

	public static void main(String[] args) {
		PaintHouse a = new PaintHouse();
		int[][] costs = new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		System.out.println(a.minCost(costs));
	}

	public int minCost(int[][] costs) {
		int len = costs.length;
		if (len == 0)
			return 0;
		int[][] dp = new int[len][3];
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		for (int i = 1; i < len; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
		}
		return Math.min(Math.min(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
	}
}
