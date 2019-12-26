package algorithm.exercise.arr;

import java.util.Arrays;

/**
 * 【350. 两个数组的交集
 * II】https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 
 * @author chying
 *
 */
public class Intersectionoftwoarraysii {
	
	public static void main(String[] args) {
		Intersectionoftwoarraysii a = new Intersectionoftwoarraysii();
		int[] nums1 = new int[] { 1, 2, 2, 1, 6 };
		int[] nums2 = new int[] { 6 };
		System.out.println(Arrays.toString(a.intersect_beauty(nums1, nums2)));
	}

	public int[] intersect_beauty(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				++i;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else {
				nums1[k++] = nums1[i++];
				++j;
			}
		}
		return Arrays.copyOfRange(nums1, 0, k);
	}
}
