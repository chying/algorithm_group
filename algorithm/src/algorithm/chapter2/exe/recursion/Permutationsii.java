package algorithm.chapter2.exe.recursion;

import java.util.List;

/**
 * 【47. 全排列ii】给定一个可包含重复数字的序列，返回所有不重复的全排列。 示例: 输入: [1,1,2] 输出: [ [1,1,2],
 * [1,2,1], [2,1,1] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 
 * @author chying
 *
 */
public class Permutationsii {
	public List<List<Integer>> permuteUnique(int[] nums) {
		return null;
	}

	public static void main(String[] args) {
		Permutationsii a = new Permutationsii();
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> result = a.permuteUnique(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
