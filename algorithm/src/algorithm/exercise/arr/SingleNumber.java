package algorithm.exercise.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * 【136. 只出现一次的数字】https://leetcode-cn.com/problems/single-number/
 * 
 * @author chying
 *
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		if (null != nums && nums.length > 0) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {
				if (set.contains(nums[i])) {
					set.remove(nums[i]);
				} else {
					set.add(nums[i]);
				}
			}
			return (Integer) set.toArray()[0];
		}

		return 0;
	}

	public int singleNumber_Bit(int[] nums) {
		if (null != nums && nums.length > 0) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum ^= nums[i];
			}
			return sum;
		}
		return 0;
	}

	public static void main(String[] args) {
		SingleNumber a = new SingleNumber();
		int[] nums = new int[] { 4, 1, 2, 1, 2 };
		System.out.println(a.singleNumber(nums));
	}
}
