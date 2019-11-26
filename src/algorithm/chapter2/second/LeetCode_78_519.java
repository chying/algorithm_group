package algorithm.chapter2.second;

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
public class LeetCode_78_519 {
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int num : nums) {
			int len = result.size();
			for (int i = 0; i < len; i++) {
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(num);
				result.add(subset);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode_78_519 a = new LeetCode_78_519();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = a.subsets1(nums);
		for (List<Integer> re : result) {
			System.out.println(re.toString());
		}
	}
}
