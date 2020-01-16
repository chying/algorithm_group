package algorithm.exercise.dp;

/**
 * 【5. 最长回文子串】https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * @author chying
 *
 */
public class LongestPalindromicSubstring2 {

	public static void main(String[] args) {
		LongestPalindromicSubstring2 a = new LongestPalindromicSubstring2();
		String s = "abbac";
		System.out.println(a.longestPalindrome_center(s));
	}

	public String longestPalindrome_center(String s) {
		String res = "";
		if (null != s) {
			int maxLen = 0;
			for (int i = 0; i < s.length(); i++) {
				int len1 = expandCenter(s, i, i);
				int len2 = expandCenter(s, i, i + 1);
				int len = Math.max(len1, len2);
				if (len > maxLen) {
					maxLen = len;
					int start = i - (len - 1) / 2;
					int end = i + len / 2;
					res = s.substring(start, end + 1);
				}
			}
		}
		return res;
	}

	private int expandCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public String longestPalindrome11(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int sLength = s.length();
		if (sLength == 1) {
			return s;
		}
		char[] chars = s.toCharArray();

		int[] result = new int[2];
		for (int i = 0; i < sLength; i++) {
			i = explore(chars, i, result);
		}
		return s.substring(result[0] + 1, result[1]);
	}

	private int explore(char[] chars, int i, int[] result) {
		int l = i;
		int r = i;
		int length = chars.length;
		while ((r + 1) < length && chars[r + 1] == chars[r]) {
			r++;
		}
		int re = r;
		while (l >= 0 && r < length && chars[l] == chars[r]) {
			l--;
			r++;
		}
		if ((r - l) > (result[1] - result[0])) {
			result[0] = l;
			result[1] = r;
		}
		return re;
	}

}
