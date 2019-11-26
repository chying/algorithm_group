package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 【78.子集】给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 说明：解集不能包含重复的子集。 示例: 输入: nums =
 * [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/subsets
 * 
 * @author chying
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		getSubSets(result, subset, nums);
		return result;
	}

	private void getSubSets(List<List<Integer>> result, List<Integer> subset, int[] nums) {
		result.add(subset);
		for (List<Integer> subs : result) {
			for (int num : nums) {
				List<Integer> subslist = new ArrayList<>(subs);
				subslist.add(num);
				result.add(subslist);
//				getSubSets(result, subslist, nums);
			}
			
		}

	}

	public static void main(String[] args) {
		Subsets a = new Subsets();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = a.subsets(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
