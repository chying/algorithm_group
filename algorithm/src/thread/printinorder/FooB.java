package thread.printinorder;

public class FooB {

	private volatile boolean c;
	private volatile boolean b;

	public FooB() {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		c = true;
	}

	public void second(Runnable printSecond) throws InterruptedException {

		while (c != true) {

		}
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		b = true;
	}

	public void third(Runnable printThird) throws InterruptedException {

		while (b != true) {

		}
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
