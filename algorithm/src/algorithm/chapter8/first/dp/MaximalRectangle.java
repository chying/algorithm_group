package algorithm.chapter8.first.dp;

/**
 * ��85. �����Ρ�����һ�������� 0 �� 1 �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ��������������
 * 
 * @author chying
 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		return 0;
	}

	public static void main(String[] args) {
		MaximalRectangle a = new MaximalRectangle();
		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		System.out.println(a.maximalRectangle(matrix));
	}
}
