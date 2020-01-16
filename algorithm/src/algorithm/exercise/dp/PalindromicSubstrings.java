package algorithm.exercise.dp;

/**
 * ¡¾647. »ØÎÄ×Ó´®¡¿ https://leetcode-cn.com/problems/palindromic-substrings/
 * 
 * @author chying
 *
 */
public class PalindromicSubstrings {

	public int countSubstrings(String s) {
		if (null != s) {
			boolean[][] dp = new boolean[s.length()][s.length()];
			int count = 0;
			for (int len = 1; len <= s.length(); len++) {
				for (int start = 0; start <= s.length() - len; start++) {
					int end = start + len - 1;
					if ((len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end)) {
						count++;
						dp[start][end] = true;
					}
				}
			}
			return count;
		}
		return 0;

	}

	public static void main(String[] args) {
		PalindromicSubstrings a = new PalindromicSubstrings();
		String s = "aaa";
		System.out.println(a.countSubstrings1(s));
	}

	public int countSubstrings1(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += getCount(s, i, i) + getCount(s, i, i + 1);
		}
		return res;
	}

	private int getCount(String s, int start, int end) {
		int res = 0;
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
			res++;
		}
		return res;
	}
}
