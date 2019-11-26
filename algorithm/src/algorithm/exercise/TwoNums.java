package algorithm.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * nums = [2, 7, 11, 15], target = 9
 * 
 * @author chying
 *
 */
public class TwoNums {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if (map.containsKey(val)) {
				result[0] = i;
				result[1] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		TwoNums a = new TwoNums();
		int[] nums=new int[] {2, 7, 11, 15};
		System.out.println(Arrays.toString(a.twoSum(nums, 9)));
	}
}
