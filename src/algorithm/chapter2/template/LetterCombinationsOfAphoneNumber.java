package algorithm.chapter2.template;

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
