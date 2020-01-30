package thread.fizzbuzzmultithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz3 {
	private int n;
	Semaphore fizz = new Semaphore(0);
	Semaphore buzz = new Semaphore(0);
	Semaphore fizzBuzz = new Semaphore(0);
	Semaphore normal = new Semaphore(1);

	public FizzBuzz3(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz". 被3整除
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 3; i <= n; i += 3) {
			if (i % 5 != 0) {
				fizz.acquire();
				printFizz.run();
				normal.release();
			}

		}
	}

	// printBuzz.run() outputs "buzz". 被5整除
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (int i = 5; i <= n; i += 5) {
			if (i % 3 != 0) {
				buzz.acquire();
				printBuzz.run();
				normal.release();
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for (int i = 15; i <= n; i += 15) {
			fizzBuzz.acquire();
			printFizzBuzz.run();
			normal.release();
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			normal.acquire();
			if (i % 3 == 0 && i % 5 == 0) {
				fizzBuzz.release();
			} else if (i % 3 == 0) {
				fizz.release();
			} else if (i % 5 == 0) {
				buzz.release();
			} else {
				printNumber.accept(i);
				normal.release();
			}
		}
	}

	public static void main(String[] args) {
		FizzBuzz3 a = new FizzBuzz3(15);
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
