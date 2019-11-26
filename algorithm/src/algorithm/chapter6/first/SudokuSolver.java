package algorithm.chapter6.first;

import java.util.Arrays;

/**
 * 【37. 解数独】编写一个程序，通过已填充的空格来解决数独问题。 一个数独的解法需遵循如下规则： 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 空白格用 '.' 表示
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		dfs(board, 0);
	}

	private boolean dfs(char[][] board, int d) {
		if (d == 81)
			return true; // found solution
		int i = d / 9, j = d % 9;
		if (board[i][j] != '.')
			return dfs(board, d + 1);// prefill number skip

		boolean[] flag = new boolean[10];
		validate(board, i, j, flag);
		for (int k = 1; k <= 9; k++) {
			if (flag[k]) {
				board[i][j] = (char) ('0' + k);
				if (dfs(board, d + 1))
					return true;
			}
		}
		board[i][j] = '.'; // if can not solve, in the wrong path, change back to '.' and out
		return false;
	}

	private void validate(char[][] board, int i, int j, boolean[] flag) {
		Arrays.fill(flag, true);
		for (int k = 0; k < 9; k++) {
			if (board[i][k] != '.')
				flag[board[i][k] - '0'] = false;
			if (board[k][j] != '.')
				flag[board[k][j] - '0'] = false;
			int r = i / 3 * 3 + k / 3;
			int c = j / 3 * 3 + k % 3;
			if (board[r][c] != '.')
				flag[board[r][c] - '0'] = false;
		}
	}

	public static void main(String[] args) {
		ValidSudoku a = new ValidSudoku();
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(a.isValidSudoku(board));

	}
}
