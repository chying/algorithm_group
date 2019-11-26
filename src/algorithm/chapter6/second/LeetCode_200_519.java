package algorithm.chapter6.second;

/**
 * 【200. 岛屿数量】给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1: 输入: 11110 11010 11000 00000 输出: 1 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_200_519 {
	public int numIslands(char[][] grid) {
		if (grid != null) {
			int count = 0;
			int m = grid.length;
			int n = grid[0].length;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1') {
						floodFill(i, j, grid, m, n);
						++count;
					}
				}
			}
			return count;
		}
		return 0;
	}

	private void floodFill(int i, int j, char[][] grid, int m, int n) {
		if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		floodFill(i + 1, j, grid, m, n);
		floodFill(i - 1, j, grid, m, n);
		floodFill(i, j + 1, grid, m, n);
		floodFill(i, j - 1, grid, m, n);
	}

	public static void main(String[] args) {

		LeetCode_200_519 a = new LeetCode_200_519();
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(a.numIslands(grid));
	}
}
