package algorithm.chapter4.first;

/**
 * 【152. 乘积最大子序列】给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。 示例 1: 输入:
 * [2,3,-2,4] 输出: 6 解释: 子数组 [2,3] 有最大乘积 6。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int max = 1;
		int min = 1;
		int re_max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(nums[i] * max, nums[i]);
			min = Math.min(nums[i] * min, nums[i]);
			re_max = Math.max(max, re_max);
		}
		return re_max;
	}

	public static void main(String[] args) {
		MaximumProductSubarray a = new MaximumProductSubarray();
		int[] nums = new int[] { 2, 3, -2, 4 };
		System.out.println(a.maxProduct(nums));
	}

	public int maxProduct1(int[] nums) {
		int max = Integer.MIN_VALUE, imax = 1, imin = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			imax = Math.max(imax * nums[i], nums[i]);
			imin = Math.min(imin * nums[i], nums[i]);

			max = Math.max(max, imax);
		}
		return max;
	}
}
