package thread.fizzbuzzmultithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
	private int n;
	private volatile int begin = 1;
	Semaphore fizz = new Semaphore(0);
	Semaphore buzz = new Semaphore(0);
	Semaphore fizzBuzz = new Semaphore(0);
	Semaphore normal = new Semaphore(1);

	public FizzBuzz(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz". 被3整除
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 3; i <= n; i += 3) {
			if (i % 3 == 0 && i % 5 == 0) {
				fizzBuzz.release();
			}
			if (i % 3 == 0) {
				printFizz.run();
			}
			fizz.acquire();
			printFizz.run();
			normal.release();
		}

	}

	// printBuzz.run() outputs "buzz". 被5整除
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (;;) {
			if (begin > n) {
				return;
			}
			buzz.acquire();
			printBuzz.run();
			normal.release();
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for (;;) {
			if (begin > n) {
				return;
			}
			fizzBuzz.acquire();
			printFizzBuzz.run();
			if (begin != n) {
				normal.release();
			}
			begin++;
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for (; begin <= n; begin++) {
			normal.acquire();
			if (begin % 3 == 0 && begin % 5 == 0) {
				fizzBuzz.release();
			} else if (begin % 3 == 0) {
				fizz.release();
			} else if (begin % 5 == 0) {
				buzz.release();
			} else {
				printNumber.accept(begin);
				normal.release();
			}
		}
	}

	public static void main(String[] args) {
		FizzBuzz a = new FizzBuzz(8);
		IntConsumer printNumber = value -> System.out.print(value + ",");

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					a.fizz(new Runnable() {
						@Override
						public void run() {
							System.out.print("fizz,");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					a.buzz(new Runnable() {
						@Override
						public void run() {
							System.out.print("buzz,");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					a.fizzbuzz(new Runnable() {
						@Override
						public void run() {
							System.out.print("fizzbuzz,");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					a.number(printNumber);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
}
