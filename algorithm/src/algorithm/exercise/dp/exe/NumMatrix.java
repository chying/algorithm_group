package algorithm.exercise.dp.exe;

/**
 * 【304. 二维区域和检索 - 矩阵不可变】
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 *
 * @author chying
 */
public class NumMatrix {

	private int[][] sum;
	private int m;
	private int n;

	// 计算累计区域和
	public NumMatrix(int[][] matrix) {
		if (matrix != null&& matrix.length>0) {
			m = matrix.length;
			n = matrix[0].length;
			sum = new int[m + 1][n + 1];
			sum[0][0] = matrix[0][0];
			for (int i = 1; i < n; i++)
				sum[0][i] = sum[0][i - 1] + matrix[0][i];

			for (int i = 1; i < m; i++)
				sum[i][0] = sum[i - 1][0] + matrix[i][0];

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
				}
			}
		}
		return;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sub1 = col1 > 0 ? sum[row2][col1 - 1] : 0;
		int sub2 = row1 > 0 ? sum[row1 - 1][col2] : 0;
		int add = row1 > 0 && col1 > 0 ? sum[row1 - 1][col1 - 1] : 0;
		return sum[row2][col2] - sub1 - sub2 + add;
	}

	public static void main(String[] args) {
//		int[][] matrix = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
//				{ 1, 0, 3, 0, 5 } };
				int[][] matrix = new int[][] {};
		NumMatrix a = new NumMatrix(matrix);
//		System.out.println(a.sumRegion(2, 1, 4, 3));// -> 8
//		System.out.println(a.sumRegion(1, 1, 2, 2));// -> 11
//		System.out.println(a.sumRegion(1, 2, 2, 4));// -> 12

	}
	
//	private int[][] dp;
//
//	public NumMatrix(int[][] matrix) {
//	    if (matrix.length == 0 || matrix[0].length == 0) return;
//	    dp = new int[matrix.length + 1][matrix[0].length + 1];
//	    for (int r = 0; r < matrix.length; r++) {
//	        for (int c = 0; c < matrix[0].length; c++) {
//	            dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
//	        }
//	    }
//	}
//
//	public int sumRegion(int row1, int col1, int row2, int col2) {
//	    return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
//	}

}
