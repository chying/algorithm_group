package algorithm.exercise.topN;

/**
 * 【414. 第三大的数】 https://leetcode-cn.com/problems/third-maximum-number/
 * 
 * @author chying
 *
 */
public class ThirdMaximumNumber {

	public static void main(String[] args) {
		ThirdMaximumNumber a = new ThirdMaximumNumber();
		int[] nums = new int[] { Integer.MIN_VALUE, 1, 1 };
		System.out.println(a.thirdMax_exchange(nums));

	}

	public int thirdMax_for(int[] nums) {

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		boolean minVal = false;
		for (int num : nums) {
			max1 = Math.max(max1, num);
		}
		for (int num : nums) {
			if (num != max1) {
				max2 = Math.max(max2, num);
			}
		}
		for (int num : nums) {
			if (num != max1 && num != max2) {
				if (num == Integer.MIN_VALUE) {
					minVal = true;
				}
				max3 = Math.max(max3, num);
			}
		}
		return max3 == Integer.MIN_VALUE && !minVal ? Math.max(max1, max2) : max3;
	}

	public int thirdMax_exchange(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;
	}

	public int thirdMax_long(int[] nums) {

		long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
		for (int num : nums) {
			if (num > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = num;
			} else if (num > secondMax && num < firstMax) {
				thirdMax = secondMax;
				secondMax = num;
			} else if (num > thirdMax && num < secondMax) {
				thirdMax = num;
			}
		}
		return (int) (thirdMax == Long.MIN_VALUE ? firstMax : thirdMax);
	}

}
