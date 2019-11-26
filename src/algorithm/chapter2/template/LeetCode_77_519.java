package algorithm.chapter2.template;

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
public class LeetCode_77_519 {
	public List<List<Integer>> combine(int n, int k) {
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

	public List<List<Integer>> combine1(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k > n || k < 0) {
			return result;
		}
		if (k == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		result = combine1(n - 1, k - 1);
		for (List<Integer> list : result) {
			list.add(n);
		}
		result.addAll(combine1(n - 1, k));
		return result;
	}

	public static void main(String[] args) {
		LeetCode_77_519 a = new LeetCode_77_519();
		List<List<Integer>> result = a.combine1(4, 3);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
