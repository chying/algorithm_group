package algorithm.chapter7.second.exe;

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
		if (left >= right) {
			return;
		}
		int mid = (left + right) >> 1;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);

		merge(array, left, mid, right);
	}

	private void merge(int[] array, int left, int mid, int right) {
		int[] arr = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			arr[k++] = array[i] > array[j] ? array[j++] : array[i++];
		}
		while (i <= mid) {
			arr[k++] = array[i++];
		}
		while (j <= right) {
			arr[k++] = array[j++];
		}

		for (int p = 0; p < arr.length; p++) {
			array[left++] = arr[p];
		}

	}

	public static void main(String[] args) {
		MergeSort a = new MergeSort();
		int[] array = new int[] { 3, 6, 2, 1, 8, 5 };
		a.mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
