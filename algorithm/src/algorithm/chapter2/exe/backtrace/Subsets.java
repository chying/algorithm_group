package algorithm.chapter2.exe.backtrace;

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
		if (nums != null && nums.length > 0) {
			List<Integer> subList = new ArrayList<>();
			result.add(subList);
			for (int num : nums) {
				int size = result.size();
				for (int i = 0; i < size; i++) {
					List<Integer> sublist = new ArrayList<>(result.get(i));
					sublist.add(num);
					result.add(sublist);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Subsets a = new Subsets();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = a.subsets(nums);
		for (List list : result) {
			System.out.println(list.toString());
		}
	}
}
