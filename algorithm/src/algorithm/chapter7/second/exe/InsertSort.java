package algorithm.chapter7.second.exe;

import java.util.Arrays;

/**
 * ���������� ͨ�������������У�����δ�������ݣ��������������дӺ���ǰɨ�裬�ҵ���Ӧλ�ò����롣
 * 
 * @author chying
 *
 */
public class InsertSort {

	/*
	 * һ����˵���������򶼲���in-place��������ʵ�֡������㷨�������£� �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
	 * ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�裻 �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�ã�
	 * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�ã� ����Ԫ�ز��뵽��λ�ú� �ظ�����2~5��
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
