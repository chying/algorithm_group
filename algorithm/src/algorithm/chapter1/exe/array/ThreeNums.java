package algorithm.chapter1.exe.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【15.三数之和】给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 
 * @author chying
 *
 */
public class ThreeNums {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums != null && nums.length > 0) {
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				if (i == 0 || nums[i] != nums[i - 1]) {
					int lo = i + 1;
					int hi = nums.length - 1;
					int sum = 0 - nums[i];
					while (lo < hi) {
						if (sum == nums[lo] + nums[hi]) {
							result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
							while (lo < hi && nums[lo] == nums[lo + 1]) {
								lo++;
							}
							while (lo < hi && nums[hi] == nums[hi - 1]) {
								hi--;
							}
							lo++;
							hi--;
						} else {
							if (sum > nums[lo] + nums[hi]) {
								lo++;
							} else {
								hi--;
							}
						}
					}

				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		ThreeNums a = new ThreeNums();
		List<List<Integer>> result = a.threeSum(nums);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}
}
