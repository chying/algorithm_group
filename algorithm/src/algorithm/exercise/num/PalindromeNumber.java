package algorithm.exercise.num;

/**
 * ��9. ��������
 * 
 * @author chying
 *
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		PalindromeNumber a = new PalindromeNumber();
		// 2147483647
		System.out.println(a.isPalindrome_num(12321));
	}

	public boolean isPalindrome_num(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}

		// �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
		// ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
		// ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
		return x == revertedNumber || x == revertedNumber / 10;

	}
}
