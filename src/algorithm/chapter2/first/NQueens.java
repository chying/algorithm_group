package algorithm.chapter2.first;

import java.util.ArrayList;
import java.util.List;

/**
 * ��51. N�ʺ�n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * 
 * @author chying
 *
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		List<String> sublist = new ArrayList<>();
		backtrace(n, sublist, result);
		return result;
	}

	private void backtrace(int n, List<String> sublist, List<List<String>> result) {
		// terminator??

	}

	public static void main(String[] args) {
		NQueens a = new NQueens();
		List<List<String>> result = a.solveNQueens(8);
		for (List<String> list : result) {
			System.out.println(list.toString());
		}
	}
}
