package algorithm.chapter8.template.string;

/**
 * ��58. ���һ�����ʵĳ��ȡ�
 * 
 * @author chying
 *
 */
public class LeetCode_58_519 {
	/**
	 * ִ����ʱ : 0 ms , ������ java �ύ�л����� 100.00% ���û� �ڴ����� : 36.1 MB , ������ java �ύ�л�����
	 * 60.37% ���û�
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		// �մ�
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		int lastEmptyIndex = s.lastIndexOf(" ");
		return s.length() - 1 - lastEmptyIndex;
	}

	public int lengthOfLastWord3(String s) {
		if (null != s) {
			String[] arr = s.split(" ");
			if (arr.length > 0) {
				return arr[arr.length - 1].length();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		LeetCode_58_519 a = new LeetCode_58_519();
		System.out.println(a.lengthOfLastWord3("String s"));
	}

	public int lengthOfLastWord1(String s) {
		if (null != s) {
			char[] arr = s.toCharArray();
			for (int i = arr.length - 2; i >= 0; i--) {
				if (arr[i] == ' ') {
					if (arr[i + 1] == ' ') {
						return 0;
					}
					return i;
				}
			}
		}
		return 0;
	}

	public int lengthOfLastWord2(String s) {
		if (null != s) {
			int n = s.lastIndexOf(' ');
			if (n == -1) {
				return s.length();
			}
			return n;
		}
		return 0;
	}

}
