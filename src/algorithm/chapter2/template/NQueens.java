package algorithm.chapter2.template;

import java.util.List;

/**
 * ��51. N�ʺ�n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * @author chying
 *
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		return null;
	}

	public static void main(String[] args) {
		NQueens a=new NQueens();
		List<List<String>> result = a.solveNQueens(8);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}
}
