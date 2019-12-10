package algorithm.chapter1.exe.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定�?个只包括 '('�?')'�?'{'�?'}'�?'['�?']' 的字符串，判断字符串是否有效�? 有效字符串需满足�? 左括号必须用相同类型的右括号闭合�?
 * 左括号必须以正确的顺序闭合�?? 注意空字符串可被认为是有效字符串�? 示例 1: 输入: "()" 输出: true 来源：力扣（LeetCode�?
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 
 * @author chying
 *
 */
public class ValidParentheses {

	public static Map<Character, Character> map = new HashMap<>();

	static {
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}

	public boolean isValid(String s) {
		if (null != s && s.length() > 0) {
			char[] arr = s.toCharArray();
			Deque<Character> deque = new ArrayDeque<>();
			for (char c : arr) {
				if (map.containsKey(c)) {
					deque.addFirst(c);
				} else {
					if (deque.isEmpty() || c != map.get(deque.pollFirst())) {
						return false;
					}
				}
			}
			return deque.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidParentheses a = new ValidParentheses();
		String s = "]";
		System.out.println(a.isValid(s));
	}
}
