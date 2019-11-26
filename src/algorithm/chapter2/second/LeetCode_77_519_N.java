package algorithm.chapter2.second;

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
public class LeetCode_77_519_N {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		backTrace(result, temp, n, k);
		return result;
	}

	private void backTrace(List<List<Integer>> result, List<Integer> temp, int n, int k) {
		if (temp.size() == k) {
			result.add(new ArrayList<>(temp));
		} else {
			for (int i = 1; i <= n; i++) {
				if (temp.contains(i)) {
					continue;
				}
				temp.add(i);
				backTrace(result, temp, n, k);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode_77_519_N a = new LeetCode_77_519_N();
		List<List<Integer>> result = a.combine(4, 2);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}

	}
}
