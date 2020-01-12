package algorithm.contest;

import java.util.Arrays;

/**
 * 【5307. 将整数转换为两个无零整数的和】 「无零整数」是十进制表示中 不含任何 0 的正整数。 给你一个整数 n，请你返回一个 由两个整数组成的列表
 * [A, B]，满足： A 和 B 都是无零整数 A + B = n 题目数据保证至少有一个有效的解决方案。
 * 
 * @author chying
 *
 */
public class Contest_171_01 {
	public int[] getNoZeroIntegers(int n) {
		int[] result = new int[2];
		for (int i = 1; i <= n / 2; i++) {
			if (ifNotZero(i) && ifNotZero(n - i)) {
				return new int[] { i, n - i };
			}
		}
		return result;
	}

	private boolean ifNotZero(int num1) {
		while (num1 != 0) {
			if (num1 % 10 == 0) {
				return false;
			}
			num1 /= 10;
		}
		return true;
	}

	public static void main(String[] args) {
		Contest_171_01 a = new Contest_171_01();
		System.out.println(Arrays.toString(a.getNoZeroIntegers(1010)));
	}
}
