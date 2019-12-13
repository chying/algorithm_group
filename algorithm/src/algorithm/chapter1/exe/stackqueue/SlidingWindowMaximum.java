package algorithm.chapter1.exe.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 【滑动窗口最大值】 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的
 * k 个数字。滑动窗口每次只向右移动一位。 返回滑动窗口中的最大值。 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出:
 * [3,3,5,5,6,7] 解释: 滑窗口的位置 最大值 --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3
 * -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3
 * 6] 7 6 1 3 -1 -3 5 [3 6 7] 7   提示： 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k
 * ≤ 输入数组的大小。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 
 * @author chying
 *
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n - k + 1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum a = new SlidingWindowMaximum();
		int[] nums = new int[] { 1, 3, 1, 2, 0, 5 };
		/**
		 * [1,3,1,2,0,5] 3
		 */
		int k = 3;
		System.out.println(Arrays.toString(a.maxSlidingWindow3(nums, k)));
	}

	public int[] maxSlidingWindow1(int[] a, int k) {
		if (null != a && a.length > 0 && k > 0) {
			int[] arrs = new int[a.length - k + 1];
			int index = 0;
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < a.length; i++) {
				while (!deque.isEmpty() && a[deque.peekFirst()] < i - k + 1) {
					deque.pollLast();
				}
				while (!deque.isEmpty() && a[deque.peekFirst()] < arrs[i]) {
					deque.pollLast();
				}
				deque.addLast(i);
				if (i >= k - 1) {
					arrs[index++] = a[deque.peekFirst()];
				}
			}
			return arrs;
		}
		return null;
	}

	public int[] maxSlidingWindow2(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}
		int[] result = new int[a.length - k + 1];
		// 将元素下标放入队列中，
		Deque<Integer> deque = new ArrayDeque<>();
		int index = 0;

		for (int i = 0; i < a.length; i++) {
			// 队列中最后一个元素是否应该取出
			while (!deque.isEmpty() && deque.getLast() < i - k + 1) {
				deque.pollLast();
			}
			// 新添加的数据，是否大于队列中数据，将小于新数据的值，取出
			// deque中数据 应该 尾大头小的顺序
			while (!deque.isEmpty() && a[i] > a[deque.getFirst()]) {
				deque.pollFirst();
			}
			deque.addFirst(i);
			if (i >= k - 1) {
				result[index++] = a[deque.getLast()];
			}
		}
		return result;
	}

	public int[] maxSlidingWindow_DP(int[] nums, int k) {
		int n = nums.length;
		if (n * k == 0)
			return new int[0];
		if (k == 1)
			return nums;

		int[] left = new int[n];
		left[0] = nums[0];
		int[] right = new int[n];
		right[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {
			// from left to right
			if (i % k == 0)
				left[i] = nums[i]; // block_start
			else
				left[i] = Math.max(left[i - 1], nums[i]);

			// from right to left
			int j = n - i - 1;
			if ((j + 1) % k == 0)
				right[j] = nums[j]; // block_end
			else
				right[j] = Math.max(right[j + 1], nums[j]);
		}

		int[] output = new int[n - k + 1];
		for (int i = 0; i < n - k + 1; i++)
			output[i] = Math.max(left[i + k - 1], right[i]);

		return output;
	}

	public int[] maxSlidingWindow3(int[] a, int k) {
		if (null == a || a.length <= 0 || k <= 0) {
			return new int[] {};
		}

		int[] result = new int[a.length - k + 1];
		int index = 0;
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < a.length; i++) {
			while (!deque.isEmpty() && deque.getLast() <= i - k) {
				deque.pollLast();
			}
			while (!deque.isEmpty() && a[deque.getFirst()] < a[i]) {
				deque.pollFirst();
			}
			deque.addFirst(i);
			if (i >= k - 1) {
				result[index++] = a[deque.getLast()];
			}
		}

		return result;
	}

}
