package algorithm.exercise.dp;

/**
 * 【5. 最长回文子串】https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * @author chying
 *
 */
public class LongestPalindromicSubstring {
	/**
	 * 暴力破解
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		String res = "";
		if (null != s) {
			for (int i = 0; i < s.length(); i++) {
				for (int j = i; j < s.length(); j++) {
					String temp = s.substring(i, j + 1);
					if (isPalindrome(temp)) {
						if (temp.length() > res.length()) {
							res = temp;
						}
					}
				}
			}
		}
		return res;
	}

	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring a = new LongestPalindromicSubstring();
		String s = "abbac";
		System.out.println(a.longestPalindrome3(s));
	}

	public String longestPalindrome1(String s) {
		int length = s.length();
		boolean[][] P = new boolean[length][length];
		int maxLen = 0;
		String maxPal = "";
		for (int len = 1; len <= length; len++) // 遍历所有的长度
			for (int start = 0; start < length; start++) {
				int end = start + len - 1;
				if (end >= length) // 下标已经越界，结束本次循环
					break;
				// 长度为的1和2单独判断下
				P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
				if (P[start][end] && len > maxLen) {
					maxLen = len;
					maxPal = s.substring(start, end + 1);
				}
			}
		return maxPal;
	}

	public String longestPalindrome2(String s) {
		String res = "";
		if (null != s) {
			boolean[][] dp = new boolean[s.length()][s.length()];
			int maxLen = 0;
			// 遍历所有长度
			for (int len = 1; len <= s.length(); len++) {
				for (int i = 0; i <= s.length() - len; i++) {
					int j = len + i - 1;
					if ((len == 1 || len == 2 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
						if (maxLen < len) {
							maxLen = len;
							res = s.substring(i, j + 1);
						}
					}
				}
			}
		}
		return res;
	}

	public String longestPalindrome3(String s) {
		int n = s.length();
		String res = "";
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); // j - i 代表长度减去 1
				if (dp[i][j] && j - i + 1 > res.length()) {
					res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}

}
