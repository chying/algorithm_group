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

	// �ڶ�������һ��element. ����������������̱߳�����ֱ�����з�����
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
