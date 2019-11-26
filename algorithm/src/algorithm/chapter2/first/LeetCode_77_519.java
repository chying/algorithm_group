package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 【77.组合】给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 示例: 输入: n = 4, k = 2 输出: [
 * [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 
 * @author chying
 *
 */
public class LeetCode_77_519 {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		backtrace(result, sublist, 1, n, k);

		return result;
	}

	private void backtrace(List<List<Integer>> result, List<Integer> sublist, int beginnum, int n, int k) {
		if (sublist.size() == k) {
			result.add(new ArrayList<>(sublist));
		}
		for (int i = beginnum; i <= n; i++) {
			sublist.add(i);
			backtrace(result, sublist, i + 1, n, k);
			sublist.remove(sublist.size() - 1);
		}
	}

	public static void main(String[] args) {
		LeetCode_77_519 a = new LeetCode_77_519();
		List<List<Integer>> result = a.combine(4, 2);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}

	public List<List<Integer>> combine1(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			sublist.add(i);

		}
		return result;
	}
}
