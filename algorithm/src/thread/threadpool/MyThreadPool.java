package thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
	BlockingQueue<Runnable> workQueue;
//	List<WorkerThread> threads = new ArrayList<>();

	MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
		this.workQueue = workQueue; // 创建工作线程
		for (int idx = 0; idx < poolSize; idx++) {
			WorkerThread work = new WorkerThread();
			work.start();
//			threads.add(work);
		}
	}

	void execute(Runnable command) throws InterruptedException {
		workQueue.put(command);
	}

	class WorkerThread extends Thread {
		public void run() { // 循环取任务并执行
			while (true) {
				Runnable task;
				try {
					task = (Runnable) workQueue.take();
					System.out.println(1);
					task.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// 创建有界阻塞队列
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
		// 创建线程池
		MyThreadPool pool = new MyThreadPool(10, workQueue);// 提交任务

		pool.execute(() -> {
			System.out.println("hello");
		});
		pool.execute(() -> {
			System.out.println("hello");
		});

	}
}
