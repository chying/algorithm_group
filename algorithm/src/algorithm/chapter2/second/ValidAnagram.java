package algorithm.chapter2.second;

import java.util.Arrays;

/**
 * 【有效的字母异位词】给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 示例 1: 输入: s = "anagram", t
 * ="nagaram" 输出: true 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @author chying
 *
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() == t.length()) {
			char[] a1 = s.toCharArray();
			char[] a2 = t.toCharArray();
			Arrays.sort(a1);
			Arrays.sort(a2);
			return Arrays.equals(a1, a2);
		}
		return false;
	}

	public boolean isAnagram1(String s, String t) {
		if (null == s || null == t) {
			if (null == s && null == t) {
				return true;
			}
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		String s = "sab";
		String t = "sab";
		System.out.println(va.isAnagram1(s, t));
	}
}
