package algorithm.exercise.a;

public class Find {
	boolean findX(int[][] matrix, int target) {
		if (null != matrix && matrix.length > 0) {
			int m = matrix.length, n = matrix[0].length;
			int left = 0, right = m * n - 1;
			int mid = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				if (matrix[mid / n][mid % n] == target) {
					return true;
				}
				if (matrix[mid / n][mid % n] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Find a = new Find();
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int target = 13;
		System.out.println(a.findX(matrix, target));

	}
}
