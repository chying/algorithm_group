package algorithm.exercise.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 【438. 找到字符串中所有字母异位词】
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 
 * @author chying
 *
 */
public class FindAllAnagramsInAString {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] arr = new int[26];
		fillArr(arr, p);
		if (null != s && p != null && s.length() > 0 && p.length() > 0) {
			int len = p.length();
			for (int i = 0; i <= s.length() - len; i++) {
				if (arr[s.charAt(i) - 'a'] > 0) {
					int[] arr_temp = new int[26];
					fillArr(arr_temp, s.substring(i, i + len));
					if (meet(arr_temp, arr)) {
						result.add(i);
					}
				}
			}
		}
		return result;
	}

	private boolean meet(int[] arr_temp, int[] arr) {
		for (int j = 0; j < 26; j++) {
			if (arr_temp[j] != arr[j]) {
				return false;
			}
		}
		return true;
	}

	private void fillArr(int[] arr, String p) {
		char[] chArr = p.toCharArray();
		for (char ch : chArr) {
			arr[ch - 'a'] += 1;
		}
	}

	public static void main(String[] args) {
		FindAllAnagramsInAString a = new FindAllAnagramsInAString();
		String s = "cbaebabacd";
		String p = "abc";

		System.out.println(a.findAnagrams_slidewindow(s, p).toString());
	}

	public List<Integer>  findAnagrams_slidewindow(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (null != s && p != null && s.length() > 0 && p.length() > 0) {
			int[] arr = new int[26];
			fillArr(arr, p);
			int[] window = new int[26];
			int total = p.length();
			int left = 0;
			for (int right = 0; right < s.length(); right++) {
				if (arr[s.charAt(right) - 'a'] > 0) {
					window[s.charAt(right) - 'a']++;
					if (window[s.charAt(right) - 'a'] <= arr[s.charAt(right) - 'a']) {
						total--;
					}
					while (total == 0) {
						if (right - left + 1 == p.length()) {
							result.add(left);
						}
						if (arr[s.charAt(left) - 'a'] > 0) {
							window[s.charAt(left) - 'a']--;
							if (window[s.charAt(left) - 'a'] < arr[s.charAt(left) - 'a']) {
								total++;
							}
						}
						left++;
					}
				}
			}
		}
		return result;
	}

	public List<Integer> findAnagrams_1(String s, String p) {
		if (s == null || s.length() == 0)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int[] needs = new int[26]; // 由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
		int[] window = new int[26];
		int left = 0, right = 0, total = p.length(); // 用total检测窗口中是否已经涵盖了p中的字符
		for (char ch : p.toCharArray()) {
			needs[ch - 'a']++;
		}
		while (right < s.length()) {
			char chr = s.charAt(right);
			if (needs[chr - 'a'] > 0) {
				window[chr - 'a']++;
				if (window[chr - 'a'] <= needs[chr - 'a']) {
					total--;
				}
			}
			while (total == 0) {
				if (right - left + 1 == p.length()) {
					res.add(left);
				}
				char chl = s.charAt(left);
				if (needs[chl - 'a'] > 0) {
					window[chl - 'a']--;
					if (window[chl - 'a'] < needs[chl - 'a']) {
						total++;
					}
				}
				left++;
			}
			right++;
		}
		return res;
	}

}
