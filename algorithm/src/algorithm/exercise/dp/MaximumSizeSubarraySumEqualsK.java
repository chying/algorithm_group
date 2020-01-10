package algorithm.exercise.dp;

/**
 * 【325. 和等于 k 的最长子数组长度】
 * https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k/
 *
 * @author chying
 */
public class MaximumSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        return -1;
    }

    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualsK a = new MaximumSizeSubarraySumEqualsK();
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(a.maxSubArrayLen(nums, k));
    }
}
