package algorithm.chapter2.exe.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ��17. �绰�������ĸ��ϡ�����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ� �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1
 * ����Ӧ�κ���ĸ��ʾ��: ���룺"23" �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce",
 * "cf"]. ˵��: ��������Ĵ��ǰ��ֵ������еģ��������������ѡ��������˳�� ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
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
