package algorithm.chapter6.second;

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
		if (null != board) {

		}
	}

	public static void main(String[] args) {
		SudokuSolver a = new SudokuSolver();
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		a.solveSudoku(board);
		System.out.println(board.toString());
	}
}
