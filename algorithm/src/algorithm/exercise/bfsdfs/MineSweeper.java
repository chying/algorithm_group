package algorithm.exercise.bfsdfs;

import java.util.Arrays;

/**
 * 【529. 扫雷游戏】让我们一起来玩扫雷游戏！
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1'
 * 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class MineSweeper {
	private int m, n;
	int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

	public char[][] updateBoard(char[][] board, int[] click) {
		if (null != board && null != click) {
			m = board.length;
			n = board[0].length;
			int x = click[0], y = click[1];
			// 点中地雷
			if (board[x][y] == 'M') {
				board[x][y] = 'X';
				return board;
			}
			// 点中方块,相邻（8联通）方块 被暴露
			int[][] visited = new int[m][n];
			if (board[x][y] == 'E') {
				dfs(x, y, board, visited);
				return board;
			}
		}
		return null;
	}

	private void dfs(int x, int y, char[][] board, int[][] visited) {
		if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y] == 1) {
			return;
		}
		if (board[x][y] == 'E') {
			int count = 0;
			for (int i = 0; i < dx.length; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx < 0 || mx > m - 1 || my < 0 || my > n - 1 || visited[mx][my] == 1) {
					continue;
				}
				if (board[x + dx[i]][y + dy[i]] == 'M') {
					count++;
				}
			}
			visited[x][y] = 1;
			if (count > 0) {
				board[x][y] = (char) ('0' + count);
				return;
			} else {
				board[x][y] = 'B';
				for (int i = 0; i < dx.length; i++) {
					dfs(x + dx[i], y + dy[i], board, visited);
				}
			}
		}
	}

	public static void main(String[] args) {
		MineSweeper a = new MineSweeper();
		char[][] board = new char[][] { { 'B', 'B', 'B', 'B', '1', 'M', 'M', 'E' },
				{ 'B', 'B', 'B', 'B', '1', '4', 'M', 'E' }, { 'B', 'B', 'B', 'B', 'B', '3', 'M', 'E' },
				{ 'B', 'B', 'B', 'B', 'B', '2', 'M', 'E' }, { '1', '2', '2', '1', 'B', '1', '1', '1' },
				{ 'E', 'M', 'M', '1', 'B', 'B', 'B', 'B' }, { 'E', 'E', 'E', '2', '2', '2', '2', '1' },
				{ 'E', 'E', 'E', 'E', 'M', 'M', 'E', 'M' } };
		/**
		 * [["B','B','B','B','B','B','1','E'},{'B','1','1','1','B','B','1','M'},{'1','2','M','1','B','B','1','1'},{'M','2','1','1','B','B','B','B'},{'1','1','B','B','B','B','B','B'},{'B','B','B','B','B','B','B','B'},{'B','1','2','2','1','B','B','B'},{'B','1','M','M','1','B','B','B"]]
		 * [0,7]
		 */
		/**
		 * [["B','B','B','B','1','M','M','E'},{'B','B','B','B','1','4','M','E'},{'B','B','B','B','B','3','M','E'},{'B','B','B','B','B','2','M','E'},{'1','2','2','1','B','1','1','1'},{'E','M','M','1','B','B','B','B'},{'E','E','E','2','2','2','2','1'},{'E','E','E','E','M','M','E','M"]]
		 * [7,2]
		 */
		int[] click = new int[] { 0, 7 };
		a.updateBoard(board, click);
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
