package algorithm.chapter8.template.string;

/**
 * ��125. ��֤���Ĵ�������һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд�� ˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
 * ʾ�� 1: ����: "A man, a plan, a canal: Panama" ���: true ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-palindrome
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * @author chying
 *
 */
public class LeetCode_125_519 {
	public boolean isPalindrome(String s) {
		if (null != s) {
			int i = 0;
			int j = s.length() - 1;
			char[] arr = s.toCharArray();
//			while(i<j && arr[i] ) {
//				
//			}
		}
		return false;
	}

	public static void main(String[] args) {
		LeetCode_125_519 a = new LeetCode_125_519();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(a.isPalindrome(s));
	}
}
