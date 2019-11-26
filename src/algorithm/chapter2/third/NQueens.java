package algorithm.chapter2.third;

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
		List<List<String>> result = new ArrayList<>();
		List<String> subList = new ArrayList<>();
		boolean[][] arr = new boolean[n][n];
		solveNQueens(result, 0, 0, n, subList, arr);
		return result;
	}

	private void solveNQueens(List<List<String>> result, int x, int y, int n, List<String> subList, boolean[][] arr) {
		if (x > n || y > n) {
			return;
		}
		for (int i = x; i < n; i++) {
			for (int j = y; j < n; j++) {
				if (!arr[i][j]) {
					arr[i][j] = true;
					setArea(arr, i, j, n);
				} else {
					solveNQueens(result, x + 1, y + 1, n, subList, arr);
					arr[i][j] = false;
				}
			}
		}

	}

	private void setArea(boolean[][] arr, int x, int y, int n) {
		// 横坐标, 竖坐标, 正/反对角线
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == x || j == y) {
					arr[i][j] = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		NQueens a = new NQueens();
		List<List<String>> result = a.solveNQueens(4);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}
}
