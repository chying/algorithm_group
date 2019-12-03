package algorithm.chapter8.template.string;

import java.util.HashSet;
import java.util.Set;

/**
 * ��387. �ַ����еĵ�һ��Ψһ�ַ�������һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1�� ����: s =
 * "leetcode" ���� 0. s = "loveleetcode", ���� 2. ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * @author chying
 *
 */
public class FirstUniqueCharacterInAstring {

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int slow = 0, fast = 0;
		char[] chs = s.toCharArray();
		int[] count = new int[26];
		int n = chs.length;
		while (fast < n) {
			count[chs[fast] - 'a']++;
			while (slow < n && count[chs[slow] - 'a'] > 1) {
				slow++;
			}
			if (slow == n)
				return -1;
			fast++;
		}
		return slow;
	}

	public int firstUniqChar2(String s) {
		if (null != s) {
			char[] arr = s.toCharArray();
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < arr.length; i++) {
				int loc = s.lastIndexOf(arr[i]);
				if (set.add(arr[i]) && i == loc) {
					return i;
				}
			}
		}
		return -1;
	}

	public int firstUniqChar1(String s) {
		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharacterInAstring a = new FirstUniqueCharacterInAstring();
		String s = "cc";
		System.out.println(a.firstUniqChar(s));
	}
}