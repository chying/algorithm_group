package algorithm.exercise.dp.exe;

/**
 * 【304. 二维区域和检索 - 矩阵不可变】
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 *
 * @author chying
 */
public class NumMatrix {

    public NumMatrix(int[][] matrix) {

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        NumMatrix a = new NumMatrix(matrix);
        System.out.println(a.sumRegion(2, 1, 4, 3));// -> 8
        System.out.println(a.sumRegion(1, 1, 2, 2));// -> 11
        System.out.println(a.sumRegion(1, 2, 2, 4));// -> 12

    }
}
