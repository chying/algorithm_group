package algorithm.chapter1.template;

import java.util.Arrays;

/**
 * ��283.�ƶ��㡿����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳�� ʾ��: ����: [0,1,0,3,12] ���:
 * [1,3,12,0,0] ˵��: ������ԭ�����ϲ��������ܿ�����������顣 �������ٲ���������
 * https://leetcode-cn.com/problems/move-zeroes/
 * 
 * @author chying
 *
 */
public class LeetCode_283_519 {
	public int[] moveZeroes(int[] nums) {
		int zeroCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroCount++;
			} else {
				if (zeroCount > 0) {
					nums[i - zeroCount] = nums[i];
					nums[i]=0;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		LeetCode_283_519 a = new LeetCode_283_519();
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		int[] result = a.moveZeroes(nums);
		System.out.println(Arrays.toString(result));
	}
}
