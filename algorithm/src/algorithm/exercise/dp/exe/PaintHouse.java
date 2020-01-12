package algorithm.exercise.dp.exe;

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
		if (null != costs && costs.length > 0) {
			int m = costs.length;
			int[][] dp = new int[m][3];
			for (int i = 0; i < 3; i++)
				dp[0][i] = costs[0][i];
			for (int i = 1; i < m; i++) {
				for (int j = 0; j < 3; j++) {
					dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i][j];
				}
			}
			return Math.min(Math.min(dp[m - 1][0], dp[m - 1][1]), dp[m - 1][2]);
		}
		return 0;
	}
}
