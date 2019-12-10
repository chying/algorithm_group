package algorithm.chapter1.exe.stackqueue;

import java.util.Arrays;

/**
 * �?155 �?小栈】设计一个支�? push，pop，top 操作，并能在常数时间内检索到�?小元素的栈�?? push(x) -- 将元�? x 推入栈中�?
 * pop() -- 删除栈顶的元素�?? top() -- 获取栈顶元素�? getMin() -- �?索栈中的�?小元素�?? 来源：力扣（LeetCode�?
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
 * 
 * @author chying
 *
 */
public class MinStack {

	static final int DEFAULT_CAPACITY = 10;
	private int[] element;
	int min = Integer.MAX_VALUE;
	private int size;// 栈中元素个数

	public MinStack() {
		this.element = new int[DEFAULT_CAPACITY];
		this.size = 0;
	}

	/**
	 * 将元�? x 推入栈中
	 * 
	 * @param x
	 */
	public void push(int x) {
		if (this.element.length == size) {
			resize();
		}
		this.element[size] = x;
		size++;
		if (min > x) {
			min = x;
		}
	}

	private void resize() {
//		int[] n_element = new int[size * 2];
//		System.arraycopy(this.element, 0, n_element, 0, size);
//		this.element = n_element;
		
		//每次扩容1�?
		this.element = Arrays.copyOf(this.element, this.element.length + (this.element.length >> 1));
	}

	/**
	 * pop() -- 删除栈顶的元�?
	 */
	public void pop() {
		if (this.element.length != 0) {
			int element = this.top();
			size--;
			if (element == this.min) {
				this.min = Integer.MAX_VALUE;
				for (int i = 0; i < size; i++) {
					if (this.min > this.element[i]) {
						this.min = this.element[i];
					}
				}
			}
		}
	}

	/**
	 * top() -- 获取栈顶元素
	 * 
	 * @return
	 */
	public int top() {
		if (this.element.length != 0) {
			return this.element[size - 1];
		}
		return 0;
	}

	/**
	 * getMin() -- �?索栈中的�?小元�?
	 * 
	 * @return
	 */
	public int getMin() {
		return this.min;

	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(85);
		minStack.push(-99);
		minStack.push(67);
		int min1 = minStack.getMin(); // 返回 -3.
		System.out.println("min1=" + min1);
		// "push","push","push","push","push"
		// [-27],[61],[-97],[-27],[35]
		minStack.push(-27);
		minStack.push(61);
		minStack.push(-97);
		minStack.push(-27);
		minStack.push(35);
		//////////////
		int top = minStack.top();
		System.out.println("top=" + top);// 返回 35.
		minStack.push(99);
		minStack.push(-66);
		int min99 = minStack.getMin(); // 返回 --99.
		System.out.println("min99=" + min99);
		////
		minStack.push(-89);
		int min991 = minStack.getMin(); // 返回 --99.
		System.out.println("min991=" + min991);
		minStack.push(4);
		minStack.push(-70);
		int min992 = minStack.getMin(); // 返回 --99.
		System.out.println("min992=" + min992);
		////// "push","top","push","getMin"
		// [52],[],[54],[],
		minStack.push(-52);
		int top2 = minStack.top();
		System.out.println("top2=" + top2);
		minStack.push(54);
		int min993 = minStack.getMin(); // 返回 --99.
		System.out.println("min993=" + min993);
		///

	}
}
