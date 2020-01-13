package algorithm.exercise.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 【349. 两个数组的交集】 https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 
 * @author chying
 *
 */
public class IntersectionOfTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		if (null != nums1 && nums1 != null) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			Set<Integer> set1 = new HashSet<>();
			Set<Integer> set2 = new HashSet<>();
			for (int i = 0; i < nums1.length; i++) {
				if (i != 0 && nums1[i - 1] == nums1[i]) {
					continue;
				}
				set1.add(nums1[i]);
			}
			for (int i = 0; i < nums2.length; i++) {
				if (i != 0 && nums2[i - 1] == nums2[i]) {
					continue;
				}
				if (set1.contains(nums2[i])) {
					set2.add(nums2[i]);
				}
			}
			int[] output = new int[set2.size()];
			int idx = 0;
			for (int s : set2)
				output[idx++] = s;
			return output;
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		IntersectionOfTwoArrays a = new IntersectionOfTwoArrays();
		/**
		 * [4,9,5] [9,4,9,8,4]
		 */
		int[] nums1 = new int[] { 4, 9, 5 };
		int[] nums2 = new int[] { 9, 4, 9, 8, 4 };
		System.out.println(Arrays.toString(a.intersection(nums1, nums2)));
	}

	public int[] intersection1(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (Integer n : nums1)
			set1.add(n);
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (Integer n : nums2)
			set2.add(n);

		set1.retainAll(set2);

		int[] output = new int[set1.size()];
		int idx = 0;
		for (int s : set1)
			output[idx++] = s;
		return output;
	}
}
