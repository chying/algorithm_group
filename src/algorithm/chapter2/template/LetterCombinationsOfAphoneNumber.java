package algorithm.chapter2.template;

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
	public static HashMap<String, String[]> map = new HashMap<>();

	static {
		map.put("2", new String[] { "a", "b", "c" });
		map.put("3", new String[] { "d", "e", "f" });
		map.put("4", new String[] { "g", "h", "i" });
		map.put("5", new String[] { "j", "k", "l" });
		map.put("6", new String[] { "m", "n", "o" });
		map.put("7", new String[] { "p", "q", "r", "s" });
		map.put("8", new String[] { "t", "u", "v" });
		map.put("9", new String[] { "w", "x", "y", "z" });
	}

	public List<String> letterCombinations(String digits) {
		if (null == digits || "" == digits || digits.length() == 0) {
			return new ArrayList<>();
		}
		List<String> result = new ArrayList<>();
		char[] digitsArr = digits.toCharArray();
		List<String[]> characterList = new ArrayList<>();
		for (char c : digitsArr) {
			characterList.add(map.get(Character.toString(c)));
		}
		letterCombinations(result, 0, "", characterList, digits.length());
		return result;
	}

	private void letterCombinations(List<String> result, int index, String subStr, List<String[]> characterList,
			int n) {
		if (subStr.length() == n) {
			result.add(new String(subStr));
			return;
		}
		String[] val = characterList.get(index);
		for (int i = 0; i < val.length; i++) {
			subStr += val[i];
			letterCombinations(result, index + 1, subStr, characterList, n);
			subStr = subStr.substring(0, subStr.length() - 1);
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
