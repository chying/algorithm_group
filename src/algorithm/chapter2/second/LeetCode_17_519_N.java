package algorithm.chapter2.second;

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
public class LeetCode_17_519_N {
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
		List<String> result = new ArrayList<>();
		char[] digitsArr = digits.toCharArray();
		for(char c:digitsArr) {
			map.get(c);
		}
		return null;
	}

	public static void main(String[] args) {
		LeetCode_17_519_N a = new LeetCode_17_519_N();
		List<String> result = a.letterCombinations("23");

//		for (Entry<String, String[]> set : map.entrySet()) {
//			System.out.println(Arrays.toString(set.getValue()));
//		}
	}
}
