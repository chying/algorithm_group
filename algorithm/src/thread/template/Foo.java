package thread.template;

import java.util.concurrent.Semaphore;

class Foo {
	Semaphore fir = new Semaphore(1);
	Semaphore sec = new Semaphore(0);
	Semaphore thi = new Semaphore(0);

	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		fir.acquire();
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		sec.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		sec.acquire();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		thi.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		thi.acquire();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
