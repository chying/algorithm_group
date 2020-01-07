package algorithm.exercise.string;

/**
 * ¡¾76. ×îÐ¡¸²¸Ç×Ó´®¡¿ https://leetcode-cn.com/problems/minimum-window-substring/
 * 
 * @author chying
 *
 */
public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		String res = "";
		if (s != null && t != null && s.length() > 0 && t.length() > 0) {
			int[] needs = new int[256];
			for (int i = 0; i < t.length(); i++) {
				needs[t.charAt(i) - '0']++;
			}
			int[] window = new int[256];
			int total = t.length();
			int min = Integer.MAX_VALUE;
			int j = 0;
			for (int i = 0; i < s.length(); i++) {
				if (needs[s.charAt(i) - '0'] > 0) {
					window[s.charAt(i) - '0']++;
					if (window[s.charAt(i) - '0'] <= needs[s.charAt(i) - '0']) {
						total--;
					}
					while (total == 0) {
						if (min > i - j + 1) {
							min = i - j + 1;
							res = s.substring(j, i + 1);
						}
						if (needs[s.charAt(j) - '0'] > 0) {
							window[s.charAt(j) - '0']--;
							if (window[s.charAt(j) - '0'] < needs[s.charAt(j) - '0']) {
								total++;
							}
						}
						j++;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring a = new MinimumWindowSubstring();
		String s = "a", t = "a";
		System.out.println(a.minWindow(s, t));
	}
}
