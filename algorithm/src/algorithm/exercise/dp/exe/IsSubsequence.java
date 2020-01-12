package algorithm.exercise.dp.exe;

import java.util.HashSet;
import java.util.Set;

/**
 * 【392. 判断子序列】 https://leetcode-cn.com/problems/is-subsequence/
 * 
 * @author chying
 *
 */
public class IsSubsequence {

	public static void main(String[] args) {
		IsSubsequence a = new IsSubsequence();
		String s = "bcd", t = "uuubcd";
//		"abc"
//		"ahbgdc"
		System.out.println(a.isSubsequence_3(s, t));
	}

	public boolean isSubsequence_1(String s, String t) {
		if (t == null || t.length() == 0) {
			if (s == null || s.length() == 0) {
				return true;
			}
			return false;
		}
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] arr1 = s.toCharArray();// 小
		char[] arr2 = t.toCharArray();// 大
		int[][] dp = new int[arr2.length + 1][arr1.length + 1];
		for (int i = 1; i <= arr2.length; i++) {
			for (int j = 1; j <= arr1.length; j++) {
				if (arr2[i - 1] == arr1[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				if (dp[i][j] == arr1.length) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isSubsequence_compress(String s, String t) {
		if (t == null || t.length() == 0) {
			if (s == null || s.length() == 0) {
				return true;
			}
			return false;
		}
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] arr1 = s.toCharArray();// 小
		char[] arr2 = t.toCharArray();// 大
		Set<Character> set = new HashSet<>();
		for (char ch : arr1) {
			set.add(ch);
		}

		int[] dp = new int[arr1.length + 1];
		int temp, now;
		for (int i = 1; i <= arr2.length; i++) {
			temp = 0;
			if (!set.contains(arr2[i - 1])) {
				continue;
			}
			for (int j = 1; j <= arr1.length; j++) {
				now = dp[j];
				if (arr2[i - 1] == arr1[j - 1]) {
					dp[j] = temp + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				if (dp[j] == arr1.length) {
					return true;
				}
				temp = now;
			}
		}
		return false;
	}

	public boolean isSubsequence_2(String s, String t) {
		if (t == null || t.length() == 0) {
			if (s == null || s.length() == 0) {
				return true;
			}
			return false;
		}
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] arr1 = s.toCharArray();// 小
		int[] arr = new int[26];
		for (char ch : s.toCharArray()) {
			arr[ch - 'a']++;
		}
		StringBuffer sb = new StringBuffer();
		for (char ch : t.toCharArray()) {
			if (arr[ch - 'a'] > 0) {
				sb.append(ch);
			}
		}
		char[] newT = sb.toString().toCharArray();
		int[] dp = new int[arr1.length + 1];
		int temp, now;
		for (int i = 1; i <= newT.length; i++) {
			temp = 0;
			for (int j = 1; j <= arr1.length; j++) {
				now = dp[j];
				if (newT[i - 1] == arr1[j - 1]) {
					dp[j] = temp + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				if (dp[j] == arr1.length) {
					return true;
				}
				temp = now;
			}
		}
		return false;
	}

	public boolean isSubsequence_3(String s, String t) {
		if (t == null || t.length() == 0) {
			if (s == null || s.length() == 0) {
				return true;
			}
			return false;
		}
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length();
	}
}
