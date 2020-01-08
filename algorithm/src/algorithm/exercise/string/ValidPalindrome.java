package algorithm.exercise.string;

/**
 * 【125. 验证回文串】 https://leetcode-cn.com/problems/valid-palindrome/
 * 
 * @author chying
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (null != s && s.length() > 0) {
			int[] arr = new int[s.length()];
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				int num = getNum(s.charAt(i));
				if (num != -1) {
					arr[count++] = num;
				}
			}
			for (int i = 0, j = count - 1; i < j;) {
				if (arr[i] != arr[j]) {
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}

	private int getNum(char ch) {
		if (ch - '0' >= 0 && ch - '0' <= 9) {
			return ch - '0' + 27;
		}
		if (ch - 'a' >= 0 && ch - 'a' <= 26) {
			return ch - 'a';
		}
		if (ch - 'A' >= 0 && ch - 'A' <= 26) {
			return ch - 'A';
		}
		return -1;
	}

	public static void main(String[] args) {
		ValidPalindrome a = new ValidPalindrome();
		String s = " apG0i4maAs::sA0m4i0Gp0";
		System.out.println(a.isPalindrome(s));
	}

	public boolean isPalindrome_1(String s) {
		if (null != s && s.length() > 0) {
			char[] arr = new char[s.length()];
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (Character.isLetterOrDigit(s.charAt(i))) {
					arr[count++] = Character.toLowerCase(s.charAt(i));
				}
			}
			for (int i = 0, j = count - 1; i < j;) {
				if (arr[i] != arr[j]) {
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}
}
