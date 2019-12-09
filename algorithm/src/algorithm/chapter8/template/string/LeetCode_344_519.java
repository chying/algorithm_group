package algorithm.chapter8.template.string;

import java.util.Arrays;

/**
 * ¡¾344. ·´×ª×Ö·û´®¡¿
 * 
 * @author chying
 *
 */
public class LeetCode_344_519 {
	public void reverseString(char[] s) {
		if (null != s && s.length > 0) {
			int i = 0;
			int j = s.length - 1;
			while (i < j) {
				char temp = s[i];
				s[i] = s[j];
				s[j] = temp;
				i++;
				j--;
			}
		}
	}

	public static void main(String[] args) {
		LeetCode_344_519 a = new LeetCode_344_519();
		char[] s = new char[] { 'h', 'e', 'l', 'l', 'o' };
		a.reverseString(s);
		System.out.println(Arrays.toString(s));
	}
}
