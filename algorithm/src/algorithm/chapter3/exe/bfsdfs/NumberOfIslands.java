package algorithm.chapter3.exe.bfsdfs;

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
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int result = 0;
		if (null != grid && grid.length > 0) {
			int m = grid.length;
			int n = grid[0].length;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1') {
						result++;
						drillDown(i, j, m, n, grid);
					}
				}
			}
		}
		return result;
	}

	private void drillDown(int i, int j, int m, int n, char[][] grid) {
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}
		if (grid[i][j] == '1') {
			grid[i][j] = '0';
		} else {
			return;
		}
		drillDown(i + 1, j, m, n, grid);
		drillDown(i - 1, j, m, n, grid);
		drillDown(i, j + 1, m, n, grid);
		drillDown(i, j - 1, m, n, grid);

	}

	public static void main(String[] args) {
		NumberOfIslands a = new NumberOfIslands();
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };

		System.out.println(a.numIslands(grid));
	}

	private int n;
	private int m;

	public int numIslands1(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					++count;
				}
		}
		return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		int[] d = { 0, 1, 0, -1, 0 };
		for (int k = 0; k < 4; k++)
			DFSMarking(grid, i + d[k], j + d[k + 1]);
	}
}
