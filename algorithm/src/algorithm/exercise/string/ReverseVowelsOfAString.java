package algorithm.exercise.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 【345. 反转字符串中的元音字母】
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 
 * @author chying
 *
 */
public class ReverseVowelsOfAString {
	Set<Character> vowelsSet = new HashSet<>();
	{
		vowelsSet.add('a');
		vowelsSet.add('e');
		vowelsSet.add('i');
		vowelsSet.add('o');
		vowelsSet.add('u');
		vowelsSet.add('A');
		vowelsSet.add('E');
		vowelsSet.add('I');
		vowelsSet.add('O');
		vowelsSet.add('U');
	}

	public String reverseVowels(String s) {
		if (s != null) {
			char[] arr = s.toCharArray();
			for (int i = 0, j = arr.length - 1; i < j;) {
				if (isVowels(arr[i]) && isVowels(arr[j])) {
					char temp = arr[i];
					arr[i++] = arr[j];
					arr[j--] = temp;
				} else if (!isVowels(arr[i])) {
					i++;
				} else {
					j--;
				}
			}
			return String.valueOf(arr);
		}
		return s;
	}

	private boolean isVowels(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ReverseVowelsOfAString a = new ReverseVowelsOfAString();
		String s = "leetcode";
		System.out.print(a.reverseVowels(s));
	}
}
