package algorithm.chapter7.second.exe;

import java.util.Arrays;

/**
 * 【quick sort】
 * 在数组中选取标杆pivot，将小于pivot的元素放在pivot的左边，大于pivot的元素放在右边；然后依次对左右两侧子数组做快排，最终达到有序
 * 分治思想
 * 
 * @author chying
 *
 */
public class QuickSort {
	public void quickSort(int[] array, int begin, int end) {
		if (null != array) {
			if (begin >= end) {
				return;
			}
			int pivot = partition(array, begin, end);
			quickSort(array, begin, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
	}

	private int partition(int[] array, int begin, int end) {
		int count = begin;
		int pivot = end;
		for (int i = begin; i < end; i++) {
			if (array[i] < array[pivot]) {
				int temp = array[count];
				array[count] = array[i];
				array[i] = temp;
				count++;
			}
		}
		int temp = array[count];
		array[count] = array[pivot];
		array[pivot] = temp;
		return count;
	}

	public static void main(String[] args) {
		QuickSort a = new QuickSort();
		int[] array = new int[] { 3, 6, 2, 1, 8, 5 };
		a.quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
