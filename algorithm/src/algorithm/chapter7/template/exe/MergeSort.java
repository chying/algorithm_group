package algorithm.chapter7.template.exe;

import java.util.Arrays;

/**
 * ��MergeSort���鲢���� 1���ѳ���Ϊn���������зֳ���������Ϊn/2�������� 2���������������зֱ���ù鲢����
 * 3������������õ������кϲ���һ�����յ���������
 * 
 * @author chying
 *
 */
public class MergeSort {
	public void mergeSort(int[] array, int left, int right) {
		
	}



	public static void main(String[] args) {
		MergeSort a = new MergeSort();
		int[] array = new int[] { 3, 6, 2, 1, 8, 5 };
		a.mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
