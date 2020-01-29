package thread.fizzbuzzmultithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz2 {

	// Initialize the permit, limit to one.
	private Semaphore sema = new Semaphore(1);

	// The current number.
	private int curNum = 1;

	private int n;

	public FizzBuzz2(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (;;) {
			// Acquire the permit, try to run the logic exclusively.
			this.sema.acquire(1);

			try {
				if (this.curNum > n) {
					return;
				}

				if ((this.curNum % 3 == 0) && (this.curNum % 5 != 0)) {
					printFizz.run();
					this.curNum++;
				}
			} finally {
				// Release the permit anyway.
				this.sema.release(1);
			}
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (;;) {
			this.sema.acquire(1);

			try {
				if (this.curNum > n) {
					return;
				}

				if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
					printBuzz.run();
					this.curNum++;
				}
			} finally {
				this.sema.release(1);
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for (;;) {
			this.sema.acquire(1);

			try {
				if (this.curNum > n) {
					return;
				}

				if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
					printFizzBuzz.run();
					this.curNum++;
				}
			} finally {
				this.sema.release(1);
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for (;;) {
			this.sema.acquire(1);

			try {
				if (this.curNum > n) {
					return;
				}

				if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
					printNumber.accept(this.curNum);
					this.curNum++;
				}
			} finally {
				this.sema.release(1);
			}
		}
	}

	public static void main(String[] args) {
		FizzBuzz2 a = new FizzBuzz2(15);
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
