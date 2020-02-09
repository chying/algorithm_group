package thread.logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLoge {
	private AtomicInteger readNum = new AtomicInteger(0);
	private AtomicInteger dealNum = new AtomicInteger(0);
	private AtomicInteger writeNum = new AtomicInteger(0);
	ExecutorService pool = Executors.newFixedThreadPool(4);
	Map<Integer, String> map = new ConcurrentHashMap<>();
	BlockingQueue<String> queue = new LinkedBlockingDeque<String>();
//	Deque<String> queue = new ArrayDeque<>();
	volatile boolean closed = false;
	Lock lock = new ReentrantLock();
	Condition add = lock.newCondition();
	Condition minus = lock.newCondition();

	class MyReader implements Runnable {
		@Override
		public void run() {
			FileReader fr;
			try {
				fr = new FileReader("e:/a.html");
				BufferedReader br = new BufferedReader(fr);
				String str;
				while ((str = br.readLine()) != null) {
					System.out.println("readNum" + readNum.get());
					lock.lock();
					try {
						queue.add((readNum.getAndIncrement()) + str);
					} finally {
						lock.unlock();
					}

				}
				closed = true;
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		MyLoge a = new MyLoge();
		Thread read = new Thread(a.new MyReader());
		read.start();

		Thread deal = new Thread(a.new MyRunner());
		deal.start();

//		Thread write = new Thread(a.new MyWriter());
//		write.start();

//		MyRunner runner = a.new MyRunner();
//		while (!a.closed) {
//			while (a.productNum.get() < a.readNum.get()) {
//				a.pool.execute(runner);
//			}
//		}
//		MyWriter writer = a.new MyWriter();
//		a.pool.execute(writer);
//		a.pool.shutdown();

	}

	class MyRunner implements Runnable {
		@Override
		public void run() {
			while (true) {
				lock.lock();
				try {
					while (dealNum.get() < readNum.get()) {
						 System.out.println("queue.size" + queue.size());
						String s = queue.poll();
						if (s == null) {
							System.out.println("queue.size" + queue.size());
						}
						long t = (long) (Math.random() * 100);
						try {
							Thread.sleep(t);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						 System.out.println("dealNum" + dealNum.get() + s);
						map.put(dealNum.getAndIncrement(), s);
					}
				} finally {
					lock.unlock();
				}
				if (dealNum.get() == readNum.get() && closed) {
					break;
				}
			}
		}
	}

	class MyWriter implements Runnable {
		@Override
		public void run() {
			while (writeNum.get() < readNum.get()) {
				if (map.containsKey(writeNum.get())) {
					System.out.println("write" + map.get(writeNum.get()));
					map.remove(writeNum.getAndIncrement());
				}
			}
		}
	}
}
