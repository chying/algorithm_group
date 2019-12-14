package algorithm.chapter2.exe.recursion;

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
		List<String> result = new ArrayList<>();
		if (n > 0) {
			generateParenthesis_helper(0, 0, "", n, result);
		}
		return result;
	}

	private void generateParenthesis_helper(int left, int right, String val, int n, List<String> result) {
		if (left >= n && right >= n) {
			result.add(val);
			return;
		}
		if (left < n) {
			generateParenthesis_helper(left + 1, right, val + "(", n, result);
		}

		if (right < left) {
			generateParenthesis_helper(left , right+1, val + ")", n, result);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses a = new GenerateParentheses();
		System.out.println(a.generateParenthesis(3).toString());
	}
}
