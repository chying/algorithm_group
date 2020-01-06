package algorithm.exercise.topN;

import java.util.PriorityQueue;

/**
 * 【703. 数据流中的第K大元素】
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 
 * @author chying
 *
 */
public class KthLargest {
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	private int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		for (int num : nums) {
			addPQ(k, num);
		}
	}

	private void addPQ(int k, int num) {
		pq.add(num);
		if (pq.peek()> num) {
			pq.poll();
		}
	}

	public int add(int val) {
		addPQ(k, val);
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 8, 2 };
		KthLargest kthLargest = new KthLargest(3, arr);
		System.out.println(kthLargest.add(3));// returns 4
		System.out.println(kthLargest.add(5));// returns 5
		System.out.println(kthLargest.add(10));// returns 5
		System.out.println(kthLargest.add(9));// returns 8
		System.out.println(kthLargest.add(4));// returns 8

	}
}
