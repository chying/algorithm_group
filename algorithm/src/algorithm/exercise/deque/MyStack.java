package algorithm.exercise.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 【225. 用队列实现栈】
 * 
 * @author chying
 *
 */
public class MyStack {

	Deque<Integer> deque;

	/** Initialize your data structure here. */
	public MyStack() {
		deque = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		deque.addFirst(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return deque.pollFirst();
	}

	/** Get the top element. */
	public int top() {
		return deque.peekFirst();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return deque.size() == 0;
	}

	public static void main(String[] args) {
		MyStack a = new MyStack();
	}
}
