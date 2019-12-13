package algorithm.chapter2.exe.hash;

/**
 * 【242有效的字母异位词】给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 示例 1: 输入: s =
 * "anagram", t ="nagaram" 输出: true 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram 进阶:如果输入字符串包含 unicode
 * 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 * @author chying
 *
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (null != s && null != t && s.length() == t.length()) {
			int[] nums = new int[26];
			for (int i = 0; i < s.length(); i++) {
				nums[s.charAt(i) - 'a']++;
				nums[t.charAt(i) - 'a']--;
			}
			for (int num : nums) {
				if (num != 0) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		String s = "sabs";
		String t = "saba";
		System.out.println(va.isAnagram(s, t));
	}
}
