package algorithm.chapter3.exe.binsearch;

/**
 * 【74. 搜索二维矩阵】编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。 示例 1: 输入: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20],
 * [23, 30, 34, 50] ] target = 3 输出: true 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class SearchA2dMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (null != matrix && matrix.length > 0 && matrix[0].length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			int lo = 0;
			int hi = m * n - 1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				int mid_m = mid / n;
				int mid_n = mid % n;
				if (target > matrix[mid_m][mid_n]) {
					lo = mid + 1;
				} else if (target < matrix[mid_m][mid_n]) {
					hi = mid - 1;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchA2dMatrix a = new SearchA2dMatrix();
//		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int[][] matrix = new int[][] { { 1, 1 } };
		System.out.println(a.searchMatrix(matrix, 2));
	}
}
