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
		if (nums != null) {
			Arrays.sort(nums);
			int i = 0;
			int k = nums.length - 1;
			while (nums[i] <= 0 && i < k - 2) {
				int j = i + 1;
				while (nums[j] == nums[i]) {
					j++;
				}
				while (nums[k] >= 0 && j < k) {
					int target = -(nums[i] + nums[j]);
					if (target > nums[k]) {
						j++;
						while (nums[j - 1] == nums[j]) {
							j++;
						}

					} else if (target < nums[k]) {
						k--;
						while (nums[k + 1] == nums[k]) {
							k--;
						}

					}
					if (target == nums[k]) {
						List<Integer> subList = new ArrayList<>();
						subList.add(nums[i]);
						subList.add(nums[j]);
						subList.add(nums[k]);
						result.add(subList);
					}
				}
				i++;
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
