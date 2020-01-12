package algorithm.contest;

import java.util.Arrays;

/**
 * ��5307. ������ת��Ϊ�������������ĺ͡� ��������������ʮ���Ʊ�ʾ�� �����κ� 0 ���������� ����һ������ n�����㷵��һ�� ������������ɵ��б�
 * [A, B]�����㣺 A �� B ������������ A + B = n ��Ŀ���ݱ�֤������һ����Ч�Ľ��������
 * 
 * @author chying
 *
 */
public class Contest_171_01 {
	public int[] getNoZeroIntegers(int n) {
		int[] result = new int[2];
		for (int i = 1; i <= n / 2; i++) {
			if (ifNotZero(i) && ifNotZero(n - i)) {
				return new int[] { i, n - i };
			}
		}
		return result;
	}

	private boolean ifNotZero(int num1) {
		while (num1 != 0) {
			if (num1 % 10 == 0) {
				return false;
			}
			num1 /= 10;
		}
		return true;
	}

	public static void main(String[] args) {
		Contest_171_01 a = new Contest_171_01();
		System.out.println(Arrays.toString(a.getNoZeroIntegers(1010)));
	}
}
