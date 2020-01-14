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
		char[][] matrix = new char[][] { { '1', '1', '1', '0', '0' }, { '1', '1', '1', '0', '0' },
				{ '1', '1', '1', '1', '1' }, { '0', '1', '1', '1', '1' }, { '0', '1', '1', '1', '1' },
				{ '0', '1', '1', '1', '1' } };
		System.out.println(a.maximalSquaree_2(matrix));
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

	public int maximalSquaree(char[][] matrix) {
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int maxsqlen = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == '1') {
					int sqlen = 1;
					boolean flag = true;
					while (sqlen + i < rows && sqlen + j < cols && flag) {
						for (int k = j; k <= sqlen + j; k++) {
							if (matrix[i + sqlen][k] == '0') {
								flag = false;
								break;
							}
						}
						for (int k = i; k <= sqlen + i; k++) {
							if (matrix[k][j + sqlen] == '0') {
								flag = false;
								break;
							}
						}
						if (flag)
							sqlen++;
					}
					if (maxsqlen < sqlen) {
						maxsqlen = sqlen;
					}
				}
			}
		}
		return maxsqlen * maxsqlen;
	}

	public int maximalSquaree_2(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					int len = 1;
					boolean flag = false;
					while (i + len < m && j + len < n && !flag) {
						for (int k = 0; k <= len; k++) {
							if (matrix[i + len][j + k] == '0') {
								flag = !flag;
								break;
							}
						}
						for (int k = 0; k <= len; k++) {
							if (matrix[i + k][j + len] == '0') {
								flag = !flag;
								break;
							}
						}
						if (!flag) {
							max = Math.max(max, len);
							len++;
						}
					}
				}
			}
		}
		return max * max;
	}

}
