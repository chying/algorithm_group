package algorithm.chapter8.first.dp;

/**
 * 【85. 最大矩形】给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * @author chying
 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		return 0;
	}

	public static void main(String[] args) {
		MaximalRectangle a = new MaximalRectangle();
		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		System.out.println(a.maximalRectangle(matrix));
	}
}
