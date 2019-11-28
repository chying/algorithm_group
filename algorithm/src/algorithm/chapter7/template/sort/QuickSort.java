package algorithm.chapter7.template.sort;

import java.util.Arrays;

/**
 * ��quick sort��
 * ��������ѡȡ���pivot����С��pivot��Ԫ�ط���pivot����ߣ�����pivot��Ԫ�ط����ұߣ�Ȼ�����ζ��������������������ţ����մﵽ����
 * ����˼��
 * 
 * @author chying
 *
 */
public class QuickSort {
	public int[] quickSort(int[] array, int begin, int end) {
		if (begin >= end) {
			return null;
		}
		int pivot = partition(array, begin, end);
		quickSort(array, begin, pivot - 1);
		quickSort(array, pivot + 1, end);
		return array;
	}

	private int partition(int[] a, int begin, int end) {
		int pivot = end;
		int counter = begin;
		for (int i = counter; i < end; i++) {
			if (a[i] < a[pivot]) {
				int temp = a[counter];
				a[counter] = a[i];
				a[i] = temp;
				counter++;
			}
		}
		int temp = a[pivot];
		a[pivot] = a[counter];
		a[counter] = temp;
		return counter;
	}

	public static void main(String[] args) {
		QuickSort a = new QuickSort();
		int[] array = new int[] { 3, 6, 2, 1, 8, 5 };
		a.quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
