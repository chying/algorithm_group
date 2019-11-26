package algorithm.chapter3.second.dfsbfs;

import java.util.ArrayDeque;
import java.util.Deque;

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
		int island = 0;
		if (null != grid && grid.length > 0) {
			int row = grid.length;// 行
			int colum = grid[0].length;// 列
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < colum; j++) {
					if (grid[i][j] == '1') {
						island++;
						drillIsland(i, j, grid, row, colum);
					}
				}
			}
			return island;
		}
		return 0;
	}

	private void drillIsland(int x, int y, char[][] grid, int row, int column) {
		Deque<Integer> queue = new ArrayDeque<>();
		for (int c = y; c < column; c++) {
			if (grid[x][c] == '1') {
				grid[x][c] = '0';
				queue.addLast(c);
			}
		}
		while (queue.size() > 0 && ++x < row) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				for (int c = y; c < column; c++) {
					if (grid[x][c] == '1') {
						grid[x][c] = '0';
						queue.addLast(i);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		LeetCode_200_519 a = new LeetCode_200_519();
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(a.numIslands(grid));
	}
}
