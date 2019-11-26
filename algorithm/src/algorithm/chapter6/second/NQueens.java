package algorithm.chapter6.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 【51. N皇后】n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * @author chying
 *
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		// 遍历节点，设置
		List<List<String>> result = new ArrayList<>();
		List<String> sublist = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}

		backtrace(0, 0, n, board);
		return result;
	}

//回溯
	private void backtrace(int rowIndex, int colIndex, int n, char[][] board) {
		if (valide(rowIndex, colIndex, board)) {
			board[rowIndex][colIndex] = 'Q';
			backtrace(rowIndex + 1, colIndex + 1, n, board);
		}

	}

	private boolean valide(int rowIndex, int colIndex, char[][] board) {
		
		return false;
	}

	public static void main(String[] args) {
		NQueens a = new NQueens();
		List<List<String>> result = a.solveNQueens(4);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}
}
