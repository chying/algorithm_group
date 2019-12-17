package algorithm.chapter2.exe.backtrace;

import java.util.Arrays;

/**
 * 【169. 求众数】给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。 示例 1: 输入: [3,2,3] 输出: 3 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 
 * @author chying
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		if (null != nums && nums.length > 0) {
			Arrays.sort(nums);
			return nums[nums.length / 2];
		}
		return 0;
	}

	public static void main(String[] args) {
		MajorityElement a = new MajorityElement();
		int[] nums = new int[] { 3, 2, 3 };
		System.out.println(a.majorityElement(nums));
	}
}
