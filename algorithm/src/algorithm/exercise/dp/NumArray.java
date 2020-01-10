package algorithm.exercise.dp;

/**
 * 【303. 区域和检索 - 数组不可变】
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 
 * @author chying
 *
 */
public class NumArray {

	private int[] sum;

	public NumArray(int[] nums) {
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -2, 0, 3, -5, 2, -1 };
		NumArray a = new NumArray(nums);
		System.out.println(a.sumRange(0, 2));
		System.out.println(a.sumRange(2, 5));
		System.out.println(a.sumRange(0, 5));
	}
}
