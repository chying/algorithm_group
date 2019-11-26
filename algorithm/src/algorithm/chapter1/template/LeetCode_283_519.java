package algorithm.chapter1.template;

import java.util.Arrays;

/**
 * 【283.移动零】给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 示例: 输入: [0,1,0,3,12] 输出:
 * [1,3,12,0,0] 说明: 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 * https://leetcode-cn.com/problems/move-zeroes/
 * 
 * @author chying
 *
 */
public class LeetCode_283_519 {
	public int[] moveZeroes(int[] nums) {
		int zeroCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroCount++;
			} else {
				if (zeroCount > 0) {
					nums[i - zeroCount] = nums[i];
					nums[i]=0;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		LeetCode_283_519 a = new LeetCode_283_519();
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		int[] result = a.moveZeroes(nums);
		System.out.println(Arrays.toString(result));
	}
}
