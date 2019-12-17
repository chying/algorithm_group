package algorithm.chapter2.exe.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 【17. 电话号码的字母组合】给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 给出数字到字母的映射如下（与电话按键相同）。注意 1
 * 不对应任何字母。示例: 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce",
 * "cf"]. 说明: 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 
 * @author chying
 *
 */
public class LetterCombinationsOfAphoneNumber {
	public static HashMap<Character, String[]> map = new HashMap<>();

	static {
		map.put('2', new String[] { "a", "b", "c" });
		map.put('3', new String[] { "d", "e", "f" });
		map.put('4', new String[] { "g", "h", "i" });
		map.put('5', new String[] { "j", "k", "l" });
		map.put('6', new String[] { "m", "n", "o" });
		map.put('7', new String[] { "p", "q", "r", "s" });
		map.put('8', new String[] { "t", "u", "v" });
		map.put('9', new String[] { "w", "x", "y", "z" });
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (null != digits && digits.length() > 0) {
			char[] arr = digits.toCharArray();
			List<String[]> list = new ArrayList<>();
			for (char ch : arr) {
				if (map.containsKey(ch)) {
					list.add(map.get(ch));
				}
			}
			int level = list.size();
			backtrace(level, list, result, "", 0);
		}
		return result;
	}

	private void backtrace(int level, List<String[]> list, List<String> result, String val, int i) {
		if (val.length() == level) {
			result.add(val);
			return;
		}
		String[] arr = list.get(i);
		for (String str : arr) {
			val += str;
			backtrace(level, list, result, val, i + 1);
			val = val.substring(0, val.length() - 1);
		}
	}

	public static void main(String[] args) {
		LetterCombinationsOfAphoneNumber a = new LetterCombinationsOfAphoneNumber();
		List<String> result = a.letterCombinations("234");

		for (String val : result) {
			System.out.println(val);
		}
	}
}
