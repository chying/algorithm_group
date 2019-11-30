package algorithm.chapter7.second.exe;

import java.util.Arrays;

/**
 * 【插入排序】 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 
 * @author chying
 *
 */
public class InsertSort {

	/*
	 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下： 从第一个元素开始，该元素可以认为已经被排序；
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描； 如果该元素（已排序）大于新元素，将该元素移到下一位置；
	 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置； 将新元素插入到该位置后； 重复步骤2~5。
	 */
	public void insertSort(int[] array) {
		if (null != array) {
			for (int i = 1; i < array.length; i++) {
				int loc = -1;
				int temp = array[i];
				for (int j = i - 1; j >= 0; j--) {
					if (array[j] > temp) {
						array[j + 1] = array[j];
						loc = j;
					}
				}
				if (loc >= 0) {
					array[loc] = temp;
				}

			}
		}
	}

	public static void main(String[] args) {
		InsertSort a = new InsertSort();
		int[] array = new int[] { 3, 6, 2, 1, 8, 5 };
		a.insertSort(array);
		System.out.println(Arrays.toString(array));
	}
}
