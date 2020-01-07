package algorithm.exercise.string;

import java.util.Arrays;

/**
 * ��151. ��ת�ַ�����ĵ��ʡ�
 * 
 * @author chying
 *
 */
public class ReverseWordsInAString {

	public String reverseWords(String s) {
		StringBuilder ans = new StringBuilder();
		// ȥ��s����β�ո� Ȼ���ַ������
		String[] s1 = s.trim().split(" ");
		for (int i = s1.length - 1; i >= 0; i--) {
			// �ո����Ŀո���ɿ��ַ���
			if (!s1[i].equals(""))
				ans.append(s1[i] + " ");
		}
		// ȥ���������ϵĿո�
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
