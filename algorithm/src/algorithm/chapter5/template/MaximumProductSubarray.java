package algorithm.chapter5.template;

/**
 * 【152. 乘积最大子序列】
 * 
 * @author chying
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (null != nums && nums.length > 0) {
			int max = nums[0];
			int min = nums[0];
			int result = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] < 0) {
					int temp = max;
					max = min;
					min = temp;
				}
				max = Math.max(max*nums[i], nums[i]);
				min = Math.min(min*nums[i], nums[i]);
				result = Math.max(max, result);
			}
			return result;
		}
		return 0;
	}

	public static void main(String[] args) {
		MaximumProductSubarray a = new MaximumProductSubarray();
		int[] nums = new int[] { -4, -3 };

		System.out.println(a.maxProduct(nums));
	}

	public int maxProduct1(int[] nums) {
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
}
