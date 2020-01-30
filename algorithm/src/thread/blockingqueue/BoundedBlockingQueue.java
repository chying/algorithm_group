package thread.blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {
	private List<Integer> list = new ArrayList<>();
	private volatile int size = 0;
	private int capacity;

	ReentrantLock lock = new ReentrantLock();
	Condition full = lock.newCondition();
	Condition empty = lock.newCondition();

	public BoundedBlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	// �ڶ�������һ��element. ����������������̱߳�����ֱ�����з�����
	public void enqueue(int element) throws InterruptedException {
		lock.lock();
		try {
			while (capacity == size) {
				full.await();
			}
			size++;
			list.add(element);
			empty.signal();
		} finally {
			lock.unlock();
		}
	}

	// ���ض�βԪ�ز��Ӷ����н���ɾ��. �������Ϊ�գ������̱߳�����ֱ�����зǿա�
	public int dequeue() throws InterruptedException {
		lock.lock();
		try {
			while (0 == size) {
				empty.await();
			}
			size--;
			full.signal();
			return list.remove(0);
		} finally {
			lock.unlock();
		}
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) throws InterruptedException {
		BoundedBlockingQueue queue = new BoundedBlockingQueue(2);
		// ������
		Thread producer = new Thread(() -> {
			try {
				queue.enqueue(1);
				TimeUnit.SECONDS.sleep(2);
				queue.enqueue(0); // �������߳̽�0������С��������̱߳��������ͬʱ��0�������в����ء�
				queue.enqueue(2); // �������߳̽�2������С�
				queue.enqueue(3); // �������߳̽�3������С�
				queue.enqueue(4); // �������߳����ڶ��г����Ѵﵽ����2����������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "mythread-producer");
		// ������
		Thread customer = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(queue.dequeue());
				System.out.println(queue.dequeue());// ����
				TimeUnit.SECONDS.sleep(1);
				System.out.println(queue.dequeue()); // ���ڶ���Ϊ�գ��������̱߳�������
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // �������̵߳���dequeue������1��
		}, "mythread-customer");
		producer.start();
		customer.start();

//		queue.dequeue(); // �������߳̽�2�Ӷ��е��������ء��������߳̽������ͬʱ��4������С�

	}
}
