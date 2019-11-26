package algorithm.chapter2.third;

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
		generateParenthesis(result, "", 0, 0, n);
		return result;
	}

	private List<String> generateParenthesis(List<String> result, String val, int left, int right, int n) {
		if (left == n && right == n) {
			result.add(val);
			return result;
		}
		
		if (left < n) {
			generateParenthesis(result, val + "(", left + 1, right, n);
		}
		if (right < left) {
			generateParenthesis(result, val + ")", left, right + 1, n);
		}
		return result;
	}

	public static void main(String[] args) {
		GenerateParentheses a = new GenerateParentheses();
		System.out.println(a.generateParenthesis(3));
	}
}
