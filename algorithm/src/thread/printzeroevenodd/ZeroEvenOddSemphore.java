package thread.printzeroevenodd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 超时
 * 
 * @author chying
 *
 */
public class ZeroEvenOddSemphore {

	private int n;

	private Semaphore z = new Semaphore(1);
	private Semaphore e = new Semaphore(0);
	private Semaphore o = new Semaphore(0);

	public ZeroEvenOddSemphore(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			z.acquire();
			printNumber.accept(0);
			if ((i & 1) == 0) {
				o.release();
			} else {
				e.release();
			}
		}

	}

	// 偶数
	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			e.acquire();
			printNumber.accept(i);
			z.release();
		}

	}

	// 基数
	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			o.acquire();
			printNumber.accept(i);
			z.release();
		}
	}

	public static void main(String[] args) {
		try {
			ZeroEvenOddSemphore zeroEvenOdd = new ZeroEvenOddSemphore(2);
			IntConsumer intConsumer = value -> System.out.print(value);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						zeroEvenOdd.zero(intConsumer);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						zeroEvenOdd.odd(intConsumer);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						zeroEvenOdd.even(intConsumer);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
