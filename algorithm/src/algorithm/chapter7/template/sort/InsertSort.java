package algorithm.chapter7.template.sort;

import java.util.Arrays;

/**
 * ���������� ͨ�������������У�����δ�������ݣ��������������дӺ���ǰɨ�裬�ҵ���Ӧλ�ò����롣
 * 
 * @author chying
 *
 */
public class InsertSort {
	// ���裺�����н���
	/*
	 * һ����˵���������򶼲���in-place��������ʵ�֡������㷨�������£� �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
	 * ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�裻 �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�ã�
	 * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�ã� ����Ԫ�ز��뵽��λ�ú� �ظ�����2~5��
	 */
	public void insertSort(int[] array) {
		if (null != array) {
			int cur = 1;
			while (cur <= array.length - 1) {
				int newElement = array[cur];
				int count = 0;
				for (int i = cur - 1; i >= 0; i--) {
					if (newElement < array[i]) {
						array[i + 1] = array[i];
						count++;
					}
				}
				if (count > 0) {
					array[cur-count] = newElement;
				}
				cur++;
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
