package algorithm.exercise.dp.exe;

/**
 * 【5. 最长回文子串】https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * @author chying
 *
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if (null != s) {
			int maxLen = 0;
			String res = "";
			boolean[][] dp = new boolean[s.length()][s.length()];
			for (int len = 1; len <= s.length(); len++) {
				for (int start = 0; start <= s.length() - len; start++) {
					int end = start + len - 1;
					if ((len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end)) {
						dp[start][end] = true;
						if (len > maxLen) {
							maxLen = len;
							res = s.substring(start, end + 1);
						}
					}
				}
			}
			return res;
		}
		return "";
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring a = new LongestPalindromicSubstring();
		String s = "babad";
		System.out.println(a.longestPalindrome1(s));
	}

	public String longestPalindrome1(String s) {
		if (null != s) {
			int maxLen = 0;
			String res = "";
			boolean[] dp = new boolean[s.length()];
			for (int start = 0; start < s.length(); start++) {
				for (int len = 1; len <= s.length(); len++) {
					int end = start + len - 1;
					if (end >= s.length()) {
						break;
					}
					if ((len == 1 || len == 2 || dp[end - 1]) && s.charAt(start) == s.charAt(end)) {
						dp[end] = true;
						if (len > maxLen) {
							maxLen = len;
							res = s.substring(start, end + 1);
						}
					}
				}
			}
			return res;
		}
		return "";
	}
}
