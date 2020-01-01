package algorithm.chapter7.exe;

/**
 * 【52. N皇后】n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 * 
 * @author chying
 *
 */
public class NQueens2 {
	private int count;
	private int size;

	public int totalNQueens(int n) {
		count = 0;
		size = n - 1;
		return count;
	}

	public static void main(String[] args) {
		NQueens2 a = new NQueens2();
		int result = a.totalNQueens(4);
		System.out.println(result);
	}
}
