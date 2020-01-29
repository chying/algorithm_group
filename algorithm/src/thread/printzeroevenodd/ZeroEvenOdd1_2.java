package thread.printzeroevenodd;

import java.util.function.IntConsumer;

/**
 * ³¬Ê±
 * 
 * @author chying
 *
 */
public class ZeroEvenOdd1_2 {

	private int n;

	public ZeroEvenOdd1_2(int n) {
		this.n = n;
	}

	volatile int stage = 0;

	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			while (stage > 0)
				;
			printNumber.accept(0);
			if ((i & 1) == 0) {
				stage = 1;
			} else {
				stage = 2;
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			while (stage != 2)
				;
			printNumber.accept(i);
			stage = 0;
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			while (stage != 1)
				;
			printNumber.accept(i);
			stage = 0;
		}
	}

	public static void main(String[] args) {
		try {
			ZeroEvenOdd1_2 zeroEvenOdd = new ZeroEvenOdd1_2(51);
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
