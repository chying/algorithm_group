package algorithm.chapter2.template;

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
		return null;
	}

	public static void main(String[] args) {
		NQueens a=new NQueens();
		List<List<String>> result = a.solveNQueens(8);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}
}
