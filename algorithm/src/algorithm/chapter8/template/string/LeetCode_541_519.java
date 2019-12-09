package algorithm.chapter8.template.string;

/**
 * ��541. ��ת�ַ��� II������һ���ַ�����һ������ k������Ҫ�Դ��ַ�����ͷ�����ÿ�� 2k ���ַ���ǰk���ַ����з�ת�����ʣ������ k
 * ���ַ�����ʣ�������ȫ����ת�������С�� 2k �����ڻ���� k ���ַ�����תǰ k ���ַ�������ʣ����ַ�����ԭ���� ʾ��: ����: s =
 * "abcdefg", k = 2 ���: "bacdfeg" ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-string-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * @author chying
 *
 */
public class LeetCode_541_519 {

	public String reverseStr(String s, int k) {
		char[] a = s.toCharArray();
		for (int start = 0; start < a.length; start += 2 * k) {
			int i = start, j = Math.min(start + k - 1, a.length - 1);
			while (i < j) {
				char tmp = a[i];
				a[i++] = a[j];
				a[j--] = tmp;
			}
		}
		return new String(a);
	}

	public String reverseStr1(String s, int k) {
		if (null != s) {
			int len = s.length();
			int n = 0;
			boolean reverse = true;
			char[] arr = s.toCharArray();
			while (len - n * k >= 0) {
				int i = n * k;
				int j = (n + 1) * k - 1;
				j = j < len ? j : len - 1;
				while (i < j && reverse) {
					char temp = arr[j];
					arr[j--] = arr[i];
					arr[i++] = temp;
				}
				n++;
				reverse = !reverse;
			}
			return new String(arr);
		}
		return "";
	}

	public static void main(String[] args) {
		LeetCode_541_519 a = new LeetCode_541_519();
		String s = "abcd";
		int k = 8;
		System.out.println(a.reverseStr(s, k));
	}
}
