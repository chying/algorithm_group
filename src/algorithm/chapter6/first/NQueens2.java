package algorithm.chapter6.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 【51. N皇后】n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * @author chying
 *
 */
public class NQueens2 {

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(board, 0, res);
		return res;
	}

	private void dfs(char[][] board, int colIndex, List<List<String>> res) {
		if (colIndex == board.length) {
			res.add(construct(board));
			return;
		}

		for (int i = 0; i < board.length; i++) {
			if (validate(board, i, colIndex)) {
				board[i][colIndex] = 'Q';
				dfs(board, colIndex + 1, res);
				board[i][colIndex] = '.';
			}
		}
	}

	private boolean validate(char[][] board, int x, int y) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 'Q' && (Math.abs(x - i) == Math.abs(y - j) || x == i))
					return false;
			}
		}
		return true;
	}

	private List<String> construct(char[][] board) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}

	public static void main(String[] args) {
		NQueens2 a = new NQueens2();
		List<List<String>> result = a.solveNQueens(4);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}

}
