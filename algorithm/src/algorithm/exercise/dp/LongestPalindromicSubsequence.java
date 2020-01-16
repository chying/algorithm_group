package algorithm.exercise.dp;

/**
 * 【516. 最长回文子序列】
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 
 * @author chying
 *
 */
public class LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] f = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			f[i][i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					f[i][j] = f[i + 1][j - 1] + 2;
				} else {
					f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
				}
			}
		}
		return f[0][n - 1];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence a = new LongestPalindromicSubsequence();
		String s = "bbbab";
		System.out.println(a.longestPalindromeSubseq2(s));
	}

	public int longestPalindromeSubseq2(String s) {
		if (null != s) {
			int len = s.length();
			int[][] dp = new int[len][len];
			for (int i = len - 1; i >= 0; i--) {
				dp[i][i] = 1;
				for (int j = i + 1; j < len; j++) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}
			}
			return dp[0][len - 1];
		}
		return 0;
	}
}
