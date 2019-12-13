package algorithm.chapter1.exe.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * ��84. ��״ͼ�����ľ��Ρ����� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������ʾ��: ����: [2,1,5,6,2,3] ���: 10
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
	 * step 1:�����ڱ� -1 step 2:���η���������±꣬��stack top�±��Ӧ���ݽ��бȽϣ����ݱȶ����±��Ӧ�����ݴ󣬼�������ջ�У�
	 * step 3�������±����ݱ�ջ��Ԫ��С��ȡ��ջ��Ԫ�أ�֤����ʱ��ջ��Ԫ���ұ߽��ҵ������Լ��������� step 4�����αȽ�����õľ��������������ֵ
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
