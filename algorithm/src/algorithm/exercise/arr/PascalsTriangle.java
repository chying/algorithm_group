package algorithm.exercise.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ¡¾118. Ñî»ÔÈý½Ç¡¿https://leetcode-cn.com/problems/pascals-triangle/
 * 
 * @author chying
 *
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows > 0) {
			int[][] nums = new int[numRows][numRows];
			for (int i = 0; i < numRows; i++) {
				Arrays.fill(nums[i], 1);
			}
			for (int i = 0; i < numRows; i++) {
				List<Integer> subList = new ArrayList<>();
				for (int j = 0; j <= i; j++) {
					if (j > 0 && j > 0 && i != j) {
						nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
					}
					subList.add(nums[i][j]);
				}
				result.add(subList);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PascalsTriangle a = new PascalsTriangle();
		List<List<Integer>> result = a.generate(5);

		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
