package algorithm.exercise.dp.exe;

/**
 * 【516. 最长回文子序列】
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 
 * @author chying
 *
 */
public class LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
		if (null != s) {
			int maxLen = 0;
			int[][] dp = new int[maxLen][maxLen];
			for (int len = 1; len <= s.length(); len++) {
				for (int start = 0; start < s.length(); start++) {
					int end = start + len - 1;
//					if ((len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end)) {
//
//					}
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence a = new LongestPalindromicSubsequence();
		String s = "bbbab";
		System.out.println(a.longestPalindromeSubseq(s));
	}

}
