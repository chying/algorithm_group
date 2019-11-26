package algorithm.chapter6.second;

import java.util.ArrayList;
import java.util.List;

/**
 * ��51. N�ʺ�n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * @author chying
 *
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		// �����ڵ㣬����
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

//����
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
