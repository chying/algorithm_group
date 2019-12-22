package algorithm.exercise.arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 【442. 数组中重复的数据】
 * 
 * @author chying
 *
 */
public class FindAllDuplicatesInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (null != nums && nums.length > 0) {
			int[] arr = new int[nums.length + 1];
			for (int i = 0; i < nums.length; i++) {
				arr[nums[i]]++;
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 2) {
					result.add(i);
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		FindAllDuplicatesInAnArray a = new FindAllDuplicatesInAnArray();
		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(String.valueOf(a.findDuplicates(nums)));
	}
}
