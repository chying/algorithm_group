package algorithm.exercise.dp.exe;

/**
 * 【5. 最长回文子串】https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * @author chying
 *
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expand(s, i, i);
			int len2 = expand(s, i, i + 1);
			int len = Math.max(len1, len2);

		}
		return "";
	}

	private int expand(String s, int left, int right) {
		if (left < 0 || left > right || right > s.length()) {
			return 0;
		}
		if(s.charAt(left)==s.charAt(right)) {
			
		}
		return 0;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring a = new LongestPalindromicSubstring();
		String s = "babad";
		System.out.println(a.longestPalindrome(s));
	}
}
