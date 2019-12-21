package algorithm.chapter5.exe;

/**
 * 【1143. 最长公共子序列】给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。 若这两个字符串没有公共子序列，则返回 0。 示例 1: 输入：text1 =
 * "abcde", text2 = "ace" 输出：3 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {
		return 0;

	}

	public int longestCommonSubsequence11(String text1, String text2) {
		char[] s1 = text1.toCharArray();
		char[] s2 = text2.toCharArray();
		int[][] dp = new int[s1.length + 1][s2.length + 1];

		for (int i = 1; i < s1.length + 1; i++) {
			for (int j = 1; j < s2.length + 1; j++) {
				// 如果末端相同
				if (s1[i - 1] == s2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					// 如果末端不同
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[s1.length][s2.length];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence a = new LongestCommonSubsequence();
		String text1 = "bsbininm";
		String text2 = "jmjkbkjkv";
		System.out.println(a.longestCommonSubsequence(text1, text2));
	}

	/**
	 * short
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence3(String text1, String text2) {
		int n1 = text1.length();
		int n2 = text2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		return dp[n1][n2];
	}
}
