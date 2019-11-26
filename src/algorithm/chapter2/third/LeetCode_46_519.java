package algorithm.chapter2.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 【46. 全排列】给定一个没有重复数字的序列，返回其所有可能的全排列。 示例: 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 
 * @author chying
 *
 */
public class LeetCode_46_519 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		permute(result, sublist, nums);
		return result;
	}

	private void permute(List<List<Integer>> result, List<Integer> sublist, int[] nums) {
		if (sublist.size() == nums.length) {
			result.add(new ArrayList<>(sublist));
			return;
		}
		for (int j = 0; j < nums.length; j++) {
			if (sublist.contains(nums[j])) {
				continue;
			} else {
				sublist.add(nums[j]);
				permute(result, sublist, nums);
				sublist.remove(sublist.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode_46_519 a = new LeetCode_46_519();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = a.permute(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
