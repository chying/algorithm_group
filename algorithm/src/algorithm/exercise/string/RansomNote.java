package algorithm.exercise.string;

/**
 * ¡¾383. Êê½ðÐÅ¡¿ https://leetcode-cn.com/problems/ransom-note/
 * 
 * @author chying
 *
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if ((null == ransomNote && null == magazine) || (magazine.length() == 0 && ransomNote.length() == 0)) {
			return true;
		}
		if (null == ransomNote || null == magazine || (magazine.length() == 0 && ransomNote.length() != 0)) {
			return false;
		}
		if (ransomNote.length() == 0) {
			return true;
		}
		int[] needs = new int[26];
		for (int i = 0; i < ransomNote.length(); i++) {
			needs[ransomNote.charAt(i) - 'a']++;
		}
		int total = ransomNote.length();
		int[] window = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			if (needs[magazine.charAt(i) - 'a'] > 0) {
				window[magazine.charAt(i) - 'a']++;
				if (window[magazine.charAt(i) - 'a'] <= needs[magazine.charAt(i) - 'a']) {
					total--;
				}
				if (total == 0) {
					return true;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		RansomNote a = new RansomNote();
		String ransomNote = "aa";
		String magazine = "aab";
		System.out.println(a.canConstruct_1(ransomNote, magazine));
	}

	public boolean canConstruct_1(String ransom, String magazine) {
		if (magazine.length() < ransom.length())
			return false;
		int caps[] = new int[26];
		for (char c : ransom.toCharArray()) {
			int index = magazine.indexOf(c, caps[c - 'a']);
			if (index == -1)
				return false;
			caps[c - 'a'] = index + 1;
		}
		return true;
	}

}
