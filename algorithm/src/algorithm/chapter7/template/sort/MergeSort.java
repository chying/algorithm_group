package algorithm.chapter7.template.sort;

import java.util.Arrays;

/**
 * 【MergeSort】归并排序 1、把长度为n的输入序列分成两个长度为n/2的子序列 2、对这两个子序列分别采用归并排序
 * 3、将两个排序好的子序列合并成一个最终的排序序列
 * 
 * @author chying
 *
 */
public class MergeSort {
	public void mergeSort(int[] array, int left, int right) {
		if (right <= left) {
			return;
		}
		int mid = (left + right) >> 1;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, mid, right);
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		while (i <= mid)
			temp[k++] = arr[i++];
		while (j <= right)
			temp[k++] = arr[j++];
		for (int p = 0; p < temp.length; p++) {
			arr[left + p] = temp[p];
		}
	}

	public static void main(String[] args) {
		MergeSort a = new MergeSort();
		int[] array = new int[] { 3, 6, 2, 1, 8, 5 };
		a.mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
