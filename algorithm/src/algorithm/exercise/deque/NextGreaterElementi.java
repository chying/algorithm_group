package algorithm.exercise.deque;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【496. 下一个更大元素 I】 https://leetcode-cn.com/problems/next-greater-element-i/
 * 
 * @author chying
 *
 */
public class NextGreaterElementi {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums1 != null && nums2 != null) {
			int[] res = new int[nums1.length];
			Map<Integer, Integer> map = new HashMap<>();
			int count = 0;
			boolean exist = false;
			for (int i = 0; i < nums1.length; i++) {
				map.put(nums1[i], i);
			}
			for (int i = 0; count < nums1.length && i < nums2.length; i++) {
				if (map.containsKey(nums2[i])) {
					exist = false;
					for (int j = i + 1; j < nums2.length; j++) {
						if (nums2[j] > nums2[i]) {
							exist = true;
							res[map.get(nums2[i])] = nums2[j];
							break;
						}
					}
					if (!exist) {
						res[map.get(nums2[i])] = -1;
					}

				}
			}
			return res;
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		NextGreaterElementi a = new NextGreaterElementi();
		int[] nums1 = new int[] { 4, 1, 2 };
		int[] nums2 = new int[] { 1, 3, 4, 2 };
		System.out.println(Arrays.toString(a.nextGreaterElement(nums1, nums2)));
	}
}
