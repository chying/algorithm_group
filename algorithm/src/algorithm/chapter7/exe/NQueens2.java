package algorithm.chapter7.exe;

/**
 * ��52. N�ʺ�n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 * 
 * @author chying
 *
 */
public class NQueens2 {
	private int count;
	private int size;

	public int totalNQueens(int n) {
		count = 0;
		size = n - 1;
		return count;
	}

	public static void main(String[] args) {
		NQueens2 a = new NQueens2();
		int result = a.totalNQueens(4);
		System.out.println(result);
	}
}
