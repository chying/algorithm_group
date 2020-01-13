package algorithm.exercise.dp;

/**
 * 【221. 最大正方形】 https://leetcode-cn.com/problems/maximal-square/
 * 
 * @author chying
 *
 */
public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if (null != matrix && matrix.length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			int max = 0;
			int[][] dp = new int[m + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (matrix[i - 1][j - 1] == '1') {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
						max = Math.max(max, dp[i][j]);
					}
				}
			}
			return max * max;
		}
		return 0;
	}

	public static void main(String[] args) {
		MaximalSquare a = new MaximalSquare();
//		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
//				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		char[][] matrix = new char[][] { { '1' } };
		System.out.println(a.maximalSquare_1(matrix));
	}

	public int maximalSquare_1(char[][] matrix) {
		if (null != matrix && matrix.length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			int max = 0;
			int[] dp = new int[n + 1];
			int prev = 0;
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					int temp = dp[j];
					if (matrix[i - 1][j - 1] == '1') {
						dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
						max = Math.max(max, dp[j]);
					} else {
						dp[j] = 0;
					}
					prev = temp;
				}
			}
			return max * max;
		}
		return 0;
	}
}
