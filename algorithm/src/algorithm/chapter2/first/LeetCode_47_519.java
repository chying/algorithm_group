package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 【47. 全排列ii】给定一个可包含重复数字的序列，返回所有不重复的全排列。 示例: 输入: [1,1,2] 输出: [ [1,1,2],
 * [1,2,1], [2,1,1] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 
 * @author chying
 *
 */
public class LeetCode_47_519 {
	private List<List<Integer>> res = new ArrayList<>();
	private boolean[] used;

	private void findPermuteUnique(int[] nums, int depth, Stack<Integer> stack) {
		if (depth == nums.length) {
			res.add(new ArrayList<>(stack));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				}
				used[i] = true;
				stack.add(nums[i]);
				findPermuteUnique(nums, depth + 1, stack);
				stack.pop();
				used[i] = false;
			}
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return res;
		}
		Arrays.sort(nums);
		used = new boolean[len];
		findPermuteUnique(nums, 0, new Stack<>());
		return res;
	}

	public static void main(String[] args) {
		LeetCode_47_519 a = new LeetCode_47_519();
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> result = a.permuteUnique(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
