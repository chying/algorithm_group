package algorithm.exercise.bfsdfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【994. 腐烂的橘子】 https://leetcode-cn.com/problems/rotting-oranges/
 * 
 * @author chying
 *
 */
public class RottingOranges {
	private int[] dr = new int[] { -1, 0, 1, 0 };
	private int[] dc = new int[] { 0, -1, 0, 1 };

	/**
	 * 值 0 代表空单元格； 值 1 代表新鲜橘子； 值 2 代表腐烂的橘子。
	 * 
	 * @param grid
	 * @return
	 */
	public int orangesRotting(int[][] grid) {
		if (null == grid || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		int m = grid.length;
		int n = grid[0].length;
		int minutes = 0;
		Deque<Integer> deque = new ArrayDeque<>();
		boolean[][] visited = new boolean[m][n];
		boolean fresh = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					deque.add(i * n + j);
					visited[i][j] = true;
				}
			}
		}
		while (!deque.isEmpty()) {
			int size = deque.size();
			minutes++;
			for (int i = 0; i < size; i++) {
				int index = deque.poll();
				int dx = index / n;
				int dy = index % n;
				for (int k = 0; k < 4; k++) {
					int x = dx + dr[k];
					int y = dy + dc[k];
					if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
						if (!fresh) {
							fresh = !fresh;
						}
						deque.add(x * n + y);
						grid[x][y] = 2;
						visited[x][y] = true;
					}
				}
			}

		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return fresh ? minutes - 1 : 0;
	}

	public static void main(String[] args) {
		RottingOranges a = new RottingOranges();
		int[][] grid = new int[][] { { 0 } };
		System.out.println(a.orangesRotting(grid));
	}
}
