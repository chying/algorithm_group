package algorithm.chapter7.template.exe;

import java.util.Arrays;

public class BitChangeExe {
	public void bubbleSort(int[] a) {
		long t1 = System.currentTimeMillis();
		if (null != a) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					if (a[j] > a[j + 1]) {
						bitChange(a, j, j + 1);
					}
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println("bitChange:" + (t2 - t1));
	}

	public void bubbleSort1(int[] a) {
		long t1 = System.currentTimeMillis();
		if (null != a) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					if (a[j] > a[j + 1]) {
						normalChange(a, j, j + 1);
					}
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println("normalChange:" + (t2 - t1));

	}

	/**
	 * c=a^b =>a^c=b,b^c=a //交换两个数
	 * 
	 * @param a
	 */
	public void bitChange(int[] a, int index1, int index2) {
		a[index1] ^= a[index2];
		a[index2] ^= a[index1];
		a[index1] ^= a[index2];
	}

	public void normalChange(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	public static void main(String[] args) {
		BitChangeExe bitChangeExe = new BitChangeExe();
		int[] a = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
//				1, 14, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4,
//				3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,
//				10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4,
//				3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,
//				10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 13, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7,
//				6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 110, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9,
//				8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5,
//				4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,
//				10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4,
//				3, 2 };
		int[] b = a.clone();
		bitChangeExe.bubbleSort(a);
		bitChangeExe.bubbleSort1(b);
		System.out.println("数组长度：" + a.length);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}
}
