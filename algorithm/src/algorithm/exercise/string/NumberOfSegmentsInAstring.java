package algorithm.exercise.string;

/**
 * 【434. 字符串中的单词数】
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * 
 * @author chying
 *
 */
public class NumberOfSegmentsInAstring {
	public int countSegments(String s) {
		if (null != s && s.length() > 0 && s.trim().length() > 0) {
			int count = 0;
			s = s.trim();
			boolean isLetter = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ' && isLetter) {
					count++;
					isLetter = !isLetter;
				} else if (s.charAt(i) != ' ' && !isLetter) {
					isLetter = !isLetter;
				}
			}
			return count + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		NumberOfSegmentsInAstring a = new NumberOfSegmentsInAstring();
		String s = "   e  ";
		System.out.print(a.countSegments(s));
	}

	public int countSegments_1(String s) {
		int segmentCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
				segmentCount++;
			}
		}
		return segmentCount;
	}
}
