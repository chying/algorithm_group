package thread.checkaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierTest {
	// 订单队列
	static Vector<String> pos = new Vector<>();
	// 派送单队列
	static Vector<String> dos = new Vector<>();
	// 异常
	static List<String> store = new ArrayList<>();

	static AtomicInteger pnum = new AtomicInteger(0);
	static AtomicInteger dnum = new AtomicInteger(0);

	public static void main(String[] args) {
		// 执行回调的线程池
		long t1 = System.currentTimeMillis();
		// 设置为1 避免多线程并发取队列问题
		ExecutorService executor = Executors.newFixedThreadPool(1);
		final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
			// 使用线程池 有异步效果
			executor.execute(() -> check());
		});
		
		executor.shutdown();
		// 循环查询订单库
		Thread T1 = new Thread(() -> {
			int i = 0;
			while (i < 100) {
				String val = getPOrders();
//				System.out.print("pVal" + val);
				pos.add(val);
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				i++;
			}
		});
		T1.start();
		// 循环查询运单库
		Thread T2 = new Thread(() -> {
			int i = 0;
			while (i < 100) {
				String val = getDOrders();
//				System.out.println("dVal" + val);
				dos.add(val);
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				i++;
			}
		});
		T2.start();
		long t2 = System.currentTimeMillis();
		System.out.println("ffffffffffffffffffff" + (t2 - t1));
	}

	private static String getDOrders() {
		return String.valueOf(dnum.getAndIncrement());
	}

	private static String getPOrders() {
		return String.valueOf(pnum.getAndIncrement());
	}

	static void check() {
		String p = pos.remove(0);
		String d = dos.remove(0);
		System.out.println("check" + p + "check" + d);
		if (!p.equals(d)) {
			store.add("p:" + p + "d:" + d);
		}
	}
}