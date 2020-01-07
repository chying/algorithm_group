package algorithm.exercise.string;

/**
 * 【917. 仅仅反转字母】 https://leetcode-cn.com/problems/reverse-only-letters/
 * 
 * @author chying
 *
 */
public class ReverseOnlyLetters {

	public String reverseOnlyLetters(String s) {
		if (null != s && s.length() > 0) {
			char[] arr = s.toCharArray();
			for (int i = 0, j = arr.length - 1; i < j && i < arr.length && j >= 0;) {
				boolean begin = Character.isLetter(arr[i]);
				boolean end = Character.isLetter(arr[i]);
				if (begin && end) {
					char temp = arr[i];
					arr[i++] = arr[j];
					arr[j--] = temp;
				} else {
					if (!begin) {
						i++;
					} else {
						j--;
					}
				}
			}
			return String.valueOf(arr);
		}
		return s;
	}

	private boolean ifChar(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	public static void main(String[] args) {
		ReverseOnlyLetters a = new ReverseOnlyLetters();
		String s = "a-bC-dEf-ghIj";
		System.out.println(a.reverseOnlyLetters(s));

	}
}
