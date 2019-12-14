package algorithm.chapter1.exe.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 【42接雨水】给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。上面是由数组
 * [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos
 * 贡献此图。 示例: 输入: [0,1,0,2,1,0,1,3,2,1,2,1] 输出: 6 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class TrappingRainWater {
	/**
	 * 当前高度小于等于栈顶高度，入栈，指针后移。 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第
	 * 2 步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移
	 * 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		int current = 0;
		while (current < height.length) {
			// 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
			while (!stack.empty() && height[current] > height[stack.peek()]) {
				int h = height[stack.peek()]; // 取出要出栈的元素
				stack.pop(); // 出栈
				if (stack.empty()) { // 栈空就出去
					break;
				}
				int distance = current - stack.peek() - 1; // 两堵墙之前的距离。
				int min = Math.min(height[stack.peek()], height[current]);
				sum = sum + distance * (min - h);
			}
			stack.push(current); // 当前指向的墙入栈
			current++; // 指针后移
		}
		return sum;
	}

	public static void main(String[] args) {
		TrappingRainWater a = new TrappingRainWater();
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(a.trap2(height));
	}

	/**
	 * 栈中放入index
	 * 
	 * @param height
	 * @return
	 */
	public int trap1(int[] height) {
		int sum = 0;
		if (null != height && height.length > 0) {
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < height.length; i++) {
				while (!deque.isEmpty() && height[i] > height[deque.getFirst()]) {
					int h = height[deque.pollFirst()];
					if (deque.isEmpty()) {
						break;
					}
					int distance = i - deque.getFirst() - 1;
					int min = Math.min(height[deque.getFirst()], height[i]);
					sum = sum + distance * (min - h);
				}
				deque.addFirst(i);
			}

		}
		return sum;
	}

	public int trap2(int[] height) {
		int sum = 0;
		if (null != height && height.length > 0) {
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < height.length; i++) {
				while (!deque.isEmpty() && height[i] > height[deque.getFirst()]) {
					int h = height[deque.pollFirst()];
					if (deque.isEmpty()) {
						break;
					}
					int distance = i - deque.getFirst() - 1;
					int min = Math.min(height[i], height[deque.getFirst()]);
					sum += distance * (min - h);
				}
				deque.addFirst(i);
			}

		}
		return sum;
	}

}
