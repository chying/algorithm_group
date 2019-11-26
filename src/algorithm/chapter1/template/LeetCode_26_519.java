package algorithm.chapter1.template;

/**
 * 【删除排序数组中的重复项】给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 给定 nums =
 * [0,0,1,1,1,2,2,3,3,4], 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author chying
 *
 */
public class LeetCode_26_519 {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		if (null != nums && nums.length > 0) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					continue;
				}
				if (nums[i + 1] != nums[j]) {
					nums[i + 1] = nums[j];
				}
				i++;
			}
		}
		return i+1;
	}

	public static void main(String[] args) {
		LeetCode_26_519 a = new LeetCode_26_519();
//		int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int[] nums = new int[] { 0, 2,4 };
		int result = a.removeDuplicates(nums);
		System.out.println(result);
	}
}
