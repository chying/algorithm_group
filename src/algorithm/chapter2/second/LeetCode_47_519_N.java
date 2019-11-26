package algorithm.chapter2.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 【47. 全排列ii】给定一个可包含重复数字的序列，返回所有不重复的全排列。 示例: 输入: [1,1,2] 输出: [ [1,1,2],
 * [1,2,1], [2,1,1] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 
 * @author chying
 *
 */
public class LeetCode_47_519_N {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> templist = new ArrayList<>();
		Set<String> set = new HashSet<>();
		backTrace(result, templist, nums, set);
		return result;
	}

	private void backTrace(List<List<Integer>> result, List<Integer> templist, int[] nums, Set<String> set) {
		if (templist.size() == nums.length) {
			result.add(new ArrayList<>(templist));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (set.contains(nums[i] + "," + i)) {
					continue;
				}
				templist.add(nums[i]);
				set.add(nums[i] + "," + i);
				backTrace(result, templist, nums, set);
				set.remove(nums[i] + "," + i);
				templist.remove(templist.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode_47_519_N a = new LeetCode_47_519_N();
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> result = a.permuteUnique(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
