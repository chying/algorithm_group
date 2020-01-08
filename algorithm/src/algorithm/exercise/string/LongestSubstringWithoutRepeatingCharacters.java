package algorithm.exercise.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 【3. 无重复字符的最长子串】
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author chying
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		if (null != s && s.length() > 0) {
			Set<Character> set = new HashSet<>();
			int i = 0, j = 0;
			while (i < s.length() && j < s.length()) {
				if (!set.contains(s.charAt(j))) {
					set.add(s.charAt(j++));
					max = Math.max(max, j - i);
				} else {
					set.remove(s.charAt(i++));
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abcabcbb";
		System.out.println(a.lengthOfLongestSubstring(s));
	}
}
