package algorithm.exercise.arr;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ¡¾220. ´æÔÚÖØ¸´ÔªËØ III¡¿https://leetcode-cn.com/problems/contains-duplicate-iii/
 * 
 * @author chying
 *
 */
public class ContainsDuplicateiii {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (null == nums) {
			return false;
		}
		k = k > nums.length ? nums.length : k;
//		int min = nums[0];
//		for (int i = 1; i < k; i++) {
//			if (Math.abs(nums[i] - min) <= t) {
//				return true;
//			}
//		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new MyComparator());
		for (int i = 0; i < nums.length; i++) {
//			if (null != queue.peek() && Math.abs(queue.peek() - nums[i]) <= t) {
//				return true;
//			}
//			if (queue.size() > k) {
//				queue.poll();
//			}
			
			queue.add(nums[i]);
			System.out.println(queue.peek());

		}
		return false;
	}

	class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}

	public static void main(String[] args) {
		ContainsDuplicateiii a = new ContainsDuplicateiii();
		int[] nums = new int[] { 1, 9, 5, 10, 5, 9 };
		int k = 2;
		int t = 3;
		System.out.println(a.containsNearbyAlmostDuplicate(nums, k, t));
	}
}
