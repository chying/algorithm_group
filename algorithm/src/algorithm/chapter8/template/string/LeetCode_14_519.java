package algorithm.chapter8.template.string;

/**
 * 【14. 最长公共前缀】
 * 
 * @author chying
 *
 */
public class LeetCode_14_519 {
	public String longestCommonPrefix(String[] strs) {
		if (null != strs && strs.length > 0) {
			int len = strs.length;
			if (len == 1) {
				return strs[0];
			}
			for (int i = 0; i < strs[0].length(); i++) {
				char c = strs[0].charAt(i);
				for (int j = 1; j < len; j++) {
					if (i > strs[j].length() - 1 || strs[j].charAt(i) != c) {
						return strs[0].substring(0, i);
					}
				}
			}
			return strs[0];
		}
		return "";
	}

	public static void main(String[] args) {
		LeetCode_14_519 a = new LeetCode_14_519();
		String[] strs = new String[] { "c", "c" };
		System.out.println(a.longestCommonPrefix(strs));
	}
}
