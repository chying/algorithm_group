package algorithm.exercise.arr;

import java.util.Arrays;

/**
 * 【167. 两数之和 II - 输入有序数组】
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * @author chying
 *
 */
public class TwoSumiiInputArrayIsSorted {
	// 二分查找
	int start = 0;
	int end = 0;

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		if (numbers != null && numbers.length > 0 && numbers[0] < target) {
			end = numbers.length - 1;
			binSearch(numbers, target);
			// 双指针
			for (int i = 0, j = end; i < j;) {
				int temp = numbers[i] + numbers[j];
				if (temp == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				} else if (temp > target) {
					j--;
				} else {
					i++;
				}
			}
		}
		return result;
	}

	private void binSearch(int[] numbers, int target) {
		if (start > end) {
			return;
		}
		int mid = start + (end - start) / 2;
		if (numbers[mid] > target) {
			end = mid - 1;
			binSearch(numbers, target);
		}
		return;
	}

	public static void main(String[] args) {
		TwoSumiiInputArrayIsSorted a = new TwoSumiiInputArrayIsSorted();
		int[] numbers = new int[] { -1,0 };
		System.out.println(Arrays.toString(a.twoSum_1(numbers, -1)));
	}

	public int[] twoSum_1(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0, j = numbers.length - 1; i < j;) {
			int temp = numbers[i] + numbers[j];
			if (temp == target) {
				result[0] = i + 1;
				result[1] = j + 1;
				return result;
			} else if (temp > target) {
				j--;
			} else {
				i++;
			}
		}
		return result;

	}
}
