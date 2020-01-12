package algorithm.exercise.arr;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 【697. 数组的度】 https://leetcode-cn.com/problems/degree-of-an-array/
 * 
 * @author chying
 *
 */
public class DegreeOfAnArray {
	public int findShortestSubArray(int[] nums) {
		if (null != nums && nums.length > 0) {
			HashMap<Integer, Integer> left = new HashMap<>();
			HashMap<Integer, Integer> right = new HashMap<>();
			HashMap<Integer, Integer> count = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (left.get(nums[i]) == null) {
					left.put(nums[i], i);
				}
				right.put(nums[i], i);
				count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
			}
			int degree = Collections.max(count.values());
			int min = nums.length;
			for (Integer key : count.keySet()) {
				if (degree == count.get(key)) {
					min = Math.min(min, right.get(key) - left.get(key) + 1);
				}
			}
			return min;
		}
		return 0;
	}

	public static void main(String[] args) {
		DegreeOfAnArray a = new DegreeOfAnArray();
		int[] nums = new int[] { 8, 8, 7, 7, 7 };
//		?[8,8,7,7,7]
//		[1,2,2,3,1,4,2]
		System.out.print(a.findShortestSubArray_1(nums));
	}

	public int findShortestSubArray_1(int[] nums) {

		// 线性结构体
		int[] num = new int[50001];
		int[] start = new int[50001];
		int[] end = new int[50001];

		// 初始化边界值
		for (int i = 0; i < num.length; i++) {
			num[i] = 0; // 每个数的个数 初始为0
			start[i] = 50001; // 当前数的起始位置
			end[i] = -1; // 当前数的结束位置
		}

		for (int i = 0; i < nums.length; i++) {
			// 起始位置只更新一次
			if (start[nums[i]] == 50001) {
				start[nums[i]] = i;
			}

			// 更新结束位置 和 数值的数量
			end[nums[i]] = i;
			num[nums[i]]++;
		}

		// 遍历结果获取相同度的最短连续串的长度
		int max_num = num[0];
		int min_bw = end[0] - start[0] + 1;
		for (int i = 1; i < num.length; i++) {
			// 数的个数较大 直接更新
			if (max_num < num[i]) {
				max_num = num[i];
				min_bw = end[i] - start[i] + 1;
			} else if (max_num == num[i]) {
				// 数值相等 取较短的连续串的长度
				if (min_bw > end[i] - start[i] + 1) {
					min_bw = end[i] - start[i] + 1;
				}
			}
		}

		return min_bw;
	}

	public int findShortestSubArray_2(int[] nums) {
		if (null != nums && nums.length > 0) {
			// 线性结构体50000
			int[] count = new int[50];
			int[] start = new int[50];
			int[] end = new int[50];
			int firstNum = nums[0];
			for (int i = 0; i < nums.length; i++) {
				count[nums[i]]++;
				if (start[nums[i]] == 0 && firstNum != nums[i]) {
					start[nums[i]] = i;
				}
				end[nums[i]] = i;
			}
			int maxCount = 0;
			int minLen = nums.length;
			for (int i = 0; i < nums.length; i++) {
				if (maxCount < count[nums[i]]) {
					maxCount = count[nums[i]];
				}
				if (maxCount == count[nums[i]]) {
					minLen = Math.min(minLen, end[nums[i]] - start[nums[i]] + 1);
				}
			}
			
			
			return minLen;
		}
		return 0;
	}

}
