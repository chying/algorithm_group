package algorithm.exercise.dp.exe;

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
		if (null != text1 && null != text2 && text1.length() > 0 && text2.length() > 0) {
			char[] arr1 = text1.toCharArray();
			char[] arr2 = text2.toCharArray();
			int m = arr1.length, n = arr2.length;
			int[] dp = new int[n + 1];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (arr1[i] == arr2[j]) {
						dp[j + 1] = dp[j] + 1;
					} else {
						dp[j + 1] = Math.max(dp[j + 1], dp[j]);
					}
				}
			}
			return dp[n];
		}
		return 0;
	}

	public static void main(String[] args) {
		LongestCommonSubsequence a = new LongestCommonSubsequence();
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(a.longestCommonSubsequence(text1, text2));
	}

}
