package algorithm.exercise.string;

/**
 * ¡¾28. ÊµÏÖ strStr()¡¿https://leetcode-cn.com/problems/implement-strstr/
 * 
 * @author chying
 *
 */
public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
		if (null != haystack && needle != null && haystack.length() > 0 && needle.length() > 0) {
			int len1 = haystack.length();
			int len2 = needle.length();
			int j = 0;
			for (int i = 0; i < len1; i++) {
				if (haystack.charAt(i) == needle.charAt(j)) {
					j++;
					if (j == len2 - 1)
						return i;
				} else {
					j = 0;
				}
			}
		}
		if (haystack == "" || needle == "") {
			return 0;
		}
		return -1;
	}

	public static void main(String[] args) {
		ImplementStrstr a = new ImplementStrstr();
		String haystack = "";
		String needle = "";
		System.out.println(a.strStr(haystack, needle));

	}
}
