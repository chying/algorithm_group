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
public class MineSweeper2 {
	int[][] DIR = new int[][] { { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	int numRow;
	int numCol;
	boolean[][] visited;

	/**
	 * 字母 含义 点击后 M 隐藏的地雷 -> X E 隐藏的方块 -> 若是地雷，标注X； 若是空白且周围无地雷，标注B，搜索周围
	 * 若是空白且周围有地雷，标注数字，停止 B 挖出的空白，周围无地雷 No 1-8 挖出的空白，周围地雷数 No X 挖出的地雷 No
	 */
	public char[][] updateBoard(char[][] board, int[] click) {
		if (board == null || click == null) {
			return new char[0][0];
		}

		if (click.length != 2) {
			return board;
		}

		numRow = board.length;
		numCol = board[0].length;
		visited = new boolean[numRow][numCol];

		int row = click[0];
		int col = click[1];

		if (!isValidPos(row, col)) {
			return board;
		}

		if (board[row][col] == 'M') {
			board[row][col] = 'X';
		} else if (board[row][col] == 'E') {
			visited[row][col] = true;
			dfs(board, row, col);
		}

		return board;
	}

	private void dfs(char[][] board, int row, int col) {
		if (!isValidPos(row, col)) {
			return;
		}

		int numSweeper = sweeperNum(board, row, col);
		if (numSweeper > 0) {
			board[row][col] = (char) (numSweeper + '0');
			return;
		}

		board[row][col] = 'B';
		for (int[] dir : DIR) {
			int nextRow = row + dir[0];
			int nextCol = col + dir[1];
			if (isValidPos(nextRow, nextCol) && !visited[nextRow][nextCol]) {
				visited[nextRow][nextCol] = true;
				dfs(board, nextRow, nextCol);
			}
		}
	}

	private int sweeperNum(char[][] board, int row, int col) {
		int res = 0;
		for (int[] dir : DIR) {
			int nextRow = row + dir[0];
			int nextCol = col + dir[1];
			if (isValidPos(nextRow, nextCol) && board[nextRow][nextCol] == 'M') {
				res++;
			}
		}
		return res;
	}

	private boolean isValidPos(int row, int col) {
		return row >= 0 && row < numRow && col >= 0 && col < numCol;
	}

	public static void main(String[] args) {
		MineSweeper2 a = new MineSweeper2();
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
