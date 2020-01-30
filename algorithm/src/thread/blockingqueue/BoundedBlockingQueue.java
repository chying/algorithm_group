package thread.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {
	private int[] element;
	private volatile int headIndex;
	private volatile int tail;
	private int size;

	ReentrantLock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();

	public BoundedBlockingQueue(int capacity) {
		element = new int[capacity];
		headIndex = capacity - 1;
		tail = 0;
	}

	// 在队首增加一个element. 如果队列满，调用线程被阻塞直到队列非满。
	public void enqueue(int element) throws InterruptedException {
		lock.lock();
	}

	public int dequeue() throws InterruptedException {
		return 0;
	}

	public int size() {
		return 0;
	}
}
