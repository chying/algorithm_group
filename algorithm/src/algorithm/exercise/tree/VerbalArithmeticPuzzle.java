package algorithm.exercise.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 【】
 * 
 * @author chying
 *
 */
public class VerbalArithmeticPuzzle {
	public boolean isSolvable(String[] words, String result) {
		if (null != words && words.length > 0 && null != result && result.length() > 0) {
			// 出现次数最多的字符，优先选择数字
			Map<Character, Integer> map = new HashMap<>();
			// 0~9 使用情况
			int[] num = new int[10];
			// n皇后，数独谜题
			int[][] wordArr = new int[words.length][26];
			int[] resultArr = new int[26];

			for (int i = 0; i < words.length; i++) {
				char[] arr = words[i].toCharArray();
				for (char ch : arr) {
					wordArr[i][ch - 'A'] = 1;
					if (map.containsKey(ch)) {
						map.put(ch, map.get(ch) + 1);
					} else {
						map.put(ch, 1);
					}
				}
			}
			for (char ch : result.toCharArray()) {
				resultArr[ch - 'A'] = 1;
				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) + 1);
				} else {
					map.put(ch, 1);
				}
			}
			// 出现次数最多的字符，优先选择数字
			Map<Character, Integer> res_map = new HashMap<>();
			for (Entry<Character, Integer> node : map.entrySet()) {
				for (int i = 0; i < 10; i++) {
					res_map.put(node.getKey(), num[i]);
					
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {
		VerbalArithmeticPuzzle a = new VerbalArithmeticPuzzle();
		String[] words = new String[] { "SEND", "MORE" };
		String result = "MONEY";
		System.out.println(a.isSolvable(words, result));
	}
}
