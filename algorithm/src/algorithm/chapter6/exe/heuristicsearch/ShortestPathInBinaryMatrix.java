package algorithm.chapter6.exe.heuristicsearch;

/**
 * �?1091. 二进制矩阵中的最短路径�?�在�?个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）�??
 * �?条从左上角到右下角�?�长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成�? 相邻单元格 C_i
 * 和 C_{i+1} 在八个方向之�?上连通（此时，C_i 和 C_{i+1} 不同且共享边或角�? C_1 位于 (0,
 * 0)（即，�?�为 grid[0][0]�? C_k 位于 (N-1, N-1)（即，�?�为 grid[N-1][N-1]�? 如果 C_i
 * 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0�?
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 �?
 * 
 * 来源：力扣（LeetCode�?
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
 * 
 * @author chying
 *
 */
public class ShortestPathInBinaryMatrix {

	public int shortestPathBinaryMatrix_DP(int[][] grid) {
		if (null != grid && grid.length > 0) {
			int m = grid.length;
			int n = grid[0].length;
			if (grid[m - 1][n - 1] == 1 || grid[0][0] == 1)
				return -1;
			int dp[][] = new int[m][n];
			dp[m - 1][n - 1] = 1;
			for (int i = m - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (grid[i][j] == 1) {
						grid[i][j] = -1;
						continue;
					}
				}
			}

			for (int i = m - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (grid[i][j] != -1) {
//						dp[i][j] = getMin();
					}
				}
			}
			return dp[0][0];

		}
		return -1;
	}

	private int calMin(int i, int j, int k) {
		int min = i;
		if (min > j) {
			min = j;
		}
		if (min > k) {
			min = k;
		}
		return min;
	}

	public static void main(String[] args) {
		ShortestPathInBinaryMatrix a = new ShortestPathInBinaryMatrix();
//		int[][] grid = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		int[][] grid = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		System.out.println(a.shortestPathBinaryMatrix_DP(grid));
	}
}
