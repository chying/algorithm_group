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

	// 在队首增加一个element. 如果队列满，调用线程被阻塞直到队列非满。
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

	// 返回队尾元素并从队列中将其删除. 如果队列为空，调用线程被阻塞直到队列非空。
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
		// 生产者
		Thread producer = new Thread(() -> {
			try {
				queue.enqueue(1);
				TimeUnit.SECONDS.sleep(2);
				queue.enqueue(0); // 生产者线程将0插入队列。消费者线程被解除阻塞同时将0弹出队列并返回。
				queue.enqueue(2); // 生产者线程将2插入队列。
				queue.enqueue(3); // 生产者线程将3插入队列。
				queue.enqueue(4); // 生产者线程由于队列长度已达到上限2而被阻塞。
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "mythread-producer");
		// 消费者
		Thread customer = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(queue.dequeue());
				System.out.println(queue.dequeue());// 阻塞
				TimeUnit.SECONDS.sleep(1);
				System.out.println(queue.dequeue()); // 由于队列为空，消费者线程被阻塞。
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 消费者线程调用dequeue并返回1。
		}, "mythread-customer");
		producer.start();
		customer.start();

//		queue.dequeue(); // 消费者线程将2从队列弹出并返回。生产者线程解除阻塞同时将4插入队列。

	}
}
