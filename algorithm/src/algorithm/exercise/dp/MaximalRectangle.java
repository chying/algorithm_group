package algorithm.exercise.dp;

/**
 * ¡¾85. ×î´ó¾ØÐÎ¡¿ https://leetcode-cn.com/problems/maximal-rectangle/
 * 
 * @author chying
 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (null != matrix && matrix.length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			int[][][] dp = new int[m + 1][n + 1][2];
			int max = 0;
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (matrix[i - 1][j - 1] == '1') {
						dp[i][j][0] = Math.min(Math.min(dp[i - 1][j - 1][0], dp[i - 1][j][0]), dp[i][j - 1][0]) + 1;
						dp[i][j][1] = Math.min(Math.min(dp[i - 1][j - 1][1], dp[i - 1][j][1]), dp[i][j - 1][1]) + 1;
						max = Math.max(max, dp[i][j][0] * dp[i][j][1]);
					}
				}
			}
			return max;
		}
		return 0;
	}

	public static void main(String[] args) {
		MaximalRectangle a = new MaximalRectangle();
		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		System.out.println(a.maximalRectangle(matrix));
	}
}
