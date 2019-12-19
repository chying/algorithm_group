package algorithm.chapter2.exe.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 【77组合】给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 示例: 输入: n = 4, k = 2 输出: [
 * [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 
 * @author chying
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		helper(result, sublist, n, k, 1);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> sublist, int n, int k, int index) {
		if (sublist.size() == k) {
			result.add(new ArrayList<>(sublist));
			return;
		}
		for (int i = index; i <= n; i++) {
			sublist.add(i);
			helper(result, sublist, n, k, i + 1);
			sublist.remove(sublist.size() - 1);
		}
	}

	public static void main(String[] args) {
		Combinations a = new Combinations();
		List<List<Integer>> result = a.combine(4, 2);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
	
	public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();
		combine(1, result, subList, n, k);
		return result;
    }
    private void combine(int index, List<List<Integer>> result, List<Integer> subList, int n, int k) {
		if (subList.size() == k) {
			result.add(new ArrayList<>(subList));
			return;
		} else {
			for (int i = index; i <= n; i++) {
				subList.add(i);
				combine(i + 1, result, subList, n, k);
				subList.remove(subList.size() - 1);
			}
		}
	}
}
