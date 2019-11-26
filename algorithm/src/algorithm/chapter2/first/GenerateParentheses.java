package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 【22 括号生成】给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 例如，给出 n = 3，生成结果为： [
 * "((()))", "(()())", "(())()", "()(())", "()()()" ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 
 * @author chying
 *
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	private void backtrack(List<String> ans, String cur, int left, int right, int n) {
		if (cur.length() == n * 2) {
			ans.add(cur);
			return;
		}
		if (left < n) {
			backtrack(ans, cur + "(", left + 1, right, n);
		}
		if (right < left) {
			backtrack(ans, cur + ")", left, right + 1, n);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses a = new GenerateParentheses();
		List<String> result = a.generateParenthesis(3);
		for (String s : result) {
			System.out.println(s + ";");
		}

	}
}
