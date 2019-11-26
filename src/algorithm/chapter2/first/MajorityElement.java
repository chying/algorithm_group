package algorithm.chapter2.first;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 【169. 求众数】给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。 示例 1: 输入: [3,2,3] 输出: 3 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 
 * @author chying
 *
 */
public class MajorityElement {
	/**
	 * 时间复杂度O(n),空间复杂度O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		double targerNum = nums.length / 2.0;
		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if ((map.get(nums[i])) + 1 > targerNum) {
					return nums[i];
				}
				map.put(nums[i], (map.get(nums[i])) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		return -1;
	}

	/**
	 * 使用排序方法，下标为n/2处必然是众数时间复杂度 O(nlgn)
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/**
	 * Boyer-Moore 投票算法 众数是在数组中 数量查过数组长度1/2的数
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement3(int[] nums) {
		if (null == nums || nums.length == 0) {
			return -1;
		}
		int num = 1;
		int majorityElement = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (num == 0) {
				majorityElement = nums[i];
				num++;
			} else {
				if (nums[i] == majorityElement) {
					num++;
				} else {
					num--;
				}
			}

		}
		return majorityElement;
	}

	public static void main(String[] args) {
		MajorityElement a = new MajorityElement();
		int[] nums = new int[] { 6, 5, 5 };
		System.out.println(a.majorityElement3(nums));
	}
}
