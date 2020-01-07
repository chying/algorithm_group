package algorithm.exercise.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��232. ��ջʵ�ֶ��С� https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 
 * @author chying
 *
 */
public class MyQueue {

	Deque<Integer> deque;

	/** Initialize your data structure here. */
	public MyQueue() {
		deque = new LinkedList<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		deque.add(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return deque.pollFirst();
	}

	/** Get the front element. */
	public int peek() {
		return deque.peekFirst();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return deque.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.print(queue.peek()); // ���� 1
		System.out.print(queue.pop()); // ���� 1
		System.out.print(queue.empty()); // ���� false

	}
}
