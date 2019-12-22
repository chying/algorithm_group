package algorithm.exercise.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (null != nums && nums.length > 0) {
			List<Integer> result = new ArrayList<>();
			int[] arr = new int[nums.length + 1];
			for (int i = 0; i < nums.length; i++) {
				arr[nums[i]] = 1;
			}
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 0) {
					result.add(i);
				}
			}
			return result;
		}
		return null;
	}

	public static void main(String[] args) {
		FindAllNumbersDisappearedInAnArray a = new FindAllNumbersDisappearedInAnArray();
		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(String.valueOf(a.findDisappearedNumbers(nums)));
	}
}
