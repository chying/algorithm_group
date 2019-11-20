package algorithm.chapter6.first;

/**
 * 【36. 有效的数独】判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ValidSudoku {
	/**
	 * 执行用时 : 2 ms , 在所有 java 提交中击败了 97.79% 的用户 内存消耗 : 41.7 MB , 在所有 java 提交中击败了
	 * 84.85% 的用户
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.' && !check(board, i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean check(char[][] board, int x, int y) {
		char num = board[x][y];
		// 判断同一行是否合法
		for (int i = 0; i != y && i < board.length; i++) {
			if (board[x][i] == num) {
				return false;
			}
		}
		// 判断同一列是否合法
		for (int i = 0; i != x && i < board.length; i++) {
			if (board[i][y] == num) {
				return false;
			}
		}
		// 判断九宫格内是否合法
		int beginX = 3 * (x / 3);
		int beginY = 3 * (y / 3);
		for (int i = beginX; i < beginX + 3; i++) {
			for (int j = beginY; j < beginY + 3; j++) {
				if (i != x && j != y && board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
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
