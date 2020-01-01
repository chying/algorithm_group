package algorithm.exercise.arr;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 【215. 数组中的第K个最大元素】
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 
 * @author chying
 *
 */
public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		if (null != nums && nums.length > 0 && k > 0 && k <= nums.length) {
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new MyComparator());
			for (int i = 0; i < nums.length; i++) {
				if (i < k) {
					priorityQueue.add(nums[i]);
				} else {
					if (priorityQueue.peek() < nums[i]) {
						priorityQueue.poll();
						priorityQueue.add(nums[i]);
					}
				}
			}
			return priorityQueue.peek();
		}
		return -1;
	}

	class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}

	}

	public static void main(String[] args) {
		KthLargestElementInAnArray a = new KthLargestElementInAnArray();
		int[] nums = new int[] { 1 };
		int k = 1;
		System.out.println(a.findKthLargest_heap(nums, k));
	}

	public int findKthLargest_heap(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
		for (int n : nums) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}
		return heap.peek();
	}

	public int findKthLargest_heap2(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
		for (int i = 0; i < nums.length; i++) {
			if (i < k) {
				heap.add(nums[i]);
			} else {
				if (heap.peek() < nums[i]) {
					heap.poll();
					heap.add(nums[i]);
				}
			}
		}
		return heap.peek();
	}
}
