package algorithm.exercise.string;

import java.util.Arrays;

/**
 * 【151. 翻转字符串里的单词】
 * 
 * @author chying
 *
 */
public class ReverseWordsInAString {

	public String reverseWords(String s) {
		StringBuilder ans = new StringBuilder();
		// 去掉s的首尾空格 然后将字符串拆分
		String[] s1 = s.trim().split(" ");
		for (int i = s1.length - 1; i >= 0; i--) {
			// 空格后面的空格会变成空字符串
			if (!s1[i].equals(""))
				ans.append(s1[i] + " ");
		}
		// 去掉最后添加上的空格
		ans = new StringBuilder(ans.toString().trim());
		return ans.toString();
	}

	public String reverseWords_1(String s) {
		String[] parts = s.trim().split("\\s+");
		StringBuilder out = new StringBuilder();
		for (int i = parts.length - 1; i >= 0; i--) {
			out.append(parts[i] + " ");
		}
		return out.toString().trim();
	}

	public static void main(String[] args) {
		ReverseWordsInAString a = new ReverseWordsInAString();
		String s = "the sky is  blue";
		System.out.println(a.reverseWords_1(s));
	}
}
