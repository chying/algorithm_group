package algorithm.chapter1.exe.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 【84. 柱状图中最大的矩形】给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。示例: 输入: [2,1,5,6,2,3] 输出: 10
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 
 * @author chying
 *
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int maxarea = 0;
		for (int i = 0; i < heights.length; ++i) {
			while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
				maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
			}
			stack.push(i);
		}
		while (stack.peek() != -1) {
			maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
		}
		return maxarea;
	}

	public int largestRectangleArea1(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
		int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
		lessFromRight[height.length - 1] = height.length;
		lessFromLeft[0] = -1;

		for (int i = 1; i < height.length; i++) {
			int p = i - 1;
			while (p >= 0 && height[p] >= height[i]) {
				p = lessFromLeft[p];
			}
			lessFromLeft[i] = p;
		}

		for (int i = height.length - 2; i >= 0; i--) {
			int p = i + 1;
			while (p < height.length && height[p] >= height[i]) {
				p = lessFromRight[p];
			}
			lessFromRight[i] = p;
		}

		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}

		return maxArea;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram a = new LargestRectangleInHistogram();
//		int[] height = new int[] { 2, 1, 5, 6, 2, 3 };
		int[] height = new int[] { 1, 2, 5, 6 };
		System.out.println(a.largestRectangleArea5(height));
	}

	/**
	 * step 1:放入哨兵 -1 step 2:依次放入数组的下标，与stack top下标对应数据进行比较，数据比顶端下标对应的数据大，继续放入栈中，
	 * step 3：放入下标数据比栈顶元素小，取出栈顶元素，证明此时该栈顶元素右边界找到，可以计算矩形面积 step 4：依次比较新求得的矩形面积，求出最大值
	 * 
	 * @param heights
	 * @return
	 */

	public int largestRectangleArea4(int[] heights) {
		int maxArea = 0;
		if (null != heights && heights.length > 0) {
			Deque<Integer> deque = new ArrayDeque<>();
			deque.addFirst(-1);
			for (int i = 0; i < heights.length; i++) {
				while (deque.getFirst() != -1 && heights[i] < deque.getFirst()) {
					int height = heights[deque.pollFirst()];
					int area = height * (i - deque.getFirst() - 1);
					maxArea = Math.max(maxArea, area);
				}
				deque.addFirst(i);
			}
			while (!deque.isEmpty() && deque.getFirst() != -1) {
				int height = heights[deque.pollFirst()];
				int area = height * (heights.length - deque.getFirst() - 1);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

	public int largestRectangleArea5(int[] heights) {
		int maxArea = 0;
		if (null != heights && heights.length > 0) {
			Deque<Integer> deque = new ArrayDeque<>();
			deque.addFirst(-1);
			for (int i = 0; i < heights.length; i++) {
				while (deque.getFirst() != -1 && heights[deque.getFirst()] > heights[i]) {
					int area = heights[deque.pollFirst()] * (i - deque.getFirst() - 1);
					maxArea = Math.max(maxArea, area);
				}
				deque.addFirst(i);
			}
			while (deque.getFirst() != -1) {
				int area = heights[deque.pollFirst()] * (heights.length  - deque.getFirst() - 1);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}
}
