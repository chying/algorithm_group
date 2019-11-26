package algorithm.chapter1.template;

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
		int[] height = new int[] { 2, 1, 5, 6, 2, 3 };
		System.out.println(a.largestRectangleArea1(height));
	}
}
