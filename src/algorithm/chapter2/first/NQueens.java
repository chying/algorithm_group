package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 【51. N皇后】n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * @author chying
 *
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		List<String> sublist = new ArrayList<>();
		backtrace(n, sublist, result);
		return result;
	}

	private void backtrace(int n, List<String> sublist, List<List<String>> result) {
		// terminator??

	}

	public static void main(String[] args) {
		NQueens a = new NQueens();
		List<List<String>> result = a.solveNQueens(8);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}
}
