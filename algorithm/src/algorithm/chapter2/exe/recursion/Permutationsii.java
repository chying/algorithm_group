package algorithm.chapter2.exe.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 【47. 全排列ii】给定一个可包含重复数字的序列，返回所有不重复的全排列。 示例: 输入: [1,1,2] 输出: [ [1,1,2],
 * [1,2,1], [2,1,1] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 
 * @author chying
 *
 */
public class Permutationsii {
	// 层次遍历
	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums != null && nums.length > 0) {
			List<List<Integer>> result = new ArrayList<>();
			int[] visited = new int[nums.length];
			Map<Integer, List<Integer>> map = new HashMap<>();
			List<Integer> sublist = new ArrayList<>();
			backtrace(visited, map, nums, result, sublist);
			return result;
		}
		return null;
	}

	private void backtrace(int[] visited, Map<Integer, List<Integer>> map, int[] nums, List<List<Integer>> result,
			List<Integer> sublist) {
		if (sublist.size() == nums.length) {
			result.add(new ArrayList<>(sublist));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == 0) {
				int level = sublist.size();
				if (!map.containsKey(level) || !map.get(level).contains(nums[i])) {
					visited[i] = 1;
					sublist.add(nums[i]);
					if (!map.containsKey(level)) {
						map.put(level, new ArrayList<>());
					}
					map.get(level).add(nums[i]);
					backtrace(visited, map, nums, result, sublist);
					visited[i] = 0;
					sublist.remove(sublist.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Permutationsii a = new Permutationsii();
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> result = a.permuteUnique1(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}

	public List<List<Integer>> permuteUnique1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int num : nums)
			list.add(num);
		permute(list, 0, res);
		return res;
	}

	private void permute(LinkedList<Integer> nums, int start, List<List<Integer>> res) {
		if (start == nums.size() - 1) {
			res.add(new LinkedList<Integer>(nums));
			return;
		}
		for (int i = start; i < nums.size(); i++) {
			if (i > start && nums.get(i) == nums.get(i - 1))
				continue;
			nums.add(start, nums.get(i));
			nums.remove(i + 1);
			permute(nums, start + 1, res);
			nums.add(i + 1, nums.get(start));
			nums.remove(start);
		}
	}
}
