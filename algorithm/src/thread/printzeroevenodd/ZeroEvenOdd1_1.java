package thread.printzeroevenodd;

import java.util.function.IntConsumer;

class ZeroEvenOdd1_1 {

	private int n;
	private int num = 0;

	public ZeroEvenOdd1_1(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (num % 2 != 0) {
					this.wait();
				}
				printNumber.accept(0);
				num++;
				this.notifyAll();
			}
		}

	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			synchronized (this) {
				while (num % 2 == 0 || num % 4 != 3) {
					this.wait();
				}
				printNumber.accept(i);
				num++;
				this.notifyAll();
			}
		}

	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += +2) {
			synchronized (this) {
				while (num % 2 == 0 || num % 4 != 1) {
					this.wait();
				}
				printNumber.accept(i);
				num++;
				this.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		try {
//			char integer = (char) System.in.read();
//			System.out.println("´«Èën: " + integer);
//			int input = (char) integer - (char) '0';
			ZeroEvenOdd1_1 zeroEvenOdd = new ZeroEvenOdd1_1(4);
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
