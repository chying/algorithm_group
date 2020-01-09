package algorithm.exercise.string;

/**
 * °æ28.  µœ÷ strStr()°øhttps://leetcode-cn.com/problems/implement-strstr/
 * 
 * @author chying
 *
 */
public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
		if (null != haystack && needle != null) {
			int len1 = haystack.length();
			int len2 = needle.length();
			for (int i = 0; i <= len1 - len2; i++) {
				int j = 0;
				for (; j < len2; j++) {
					if (haystack.charAt(i+j) != needle.charAt(j)) {
						break;
					}
				}
				if (j == len2) {
					return i;
				}
			}
			if (len2 == 0) {
				return 0;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ImplementStrstr a = new ImplementStrstr();
		String haystack = "mississippi";
		String needle = "issip";
//		"mississippi"
//		"issip"
		System.out.println(a.strStr(haystack, needle));

	}
}
