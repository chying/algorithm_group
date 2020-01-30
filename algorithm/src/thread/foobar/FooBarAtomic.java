package thread.foobar;

import java.util.concurrent.atomic.AtomicInteger;

public class FooBarAtomic {
	private int n;

	public FooBarAtomic(int n) {
		this.n = n;
	}

	private AtomicInteger count = new AtomicInteger(0);

	public synchronized void foo(Runnable printFoo) throws InterruptedException {
		int incr = 0;
		for (int i = 0; i < n; i++) {
			while (!count.compareAndSet(incr, incr + 1)) {
				this.wait();
			}
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			incr += 2;
			this.notifyAll();
		}
	}

	public synchronized void bar(Runnable printBar) throws InterruptedException {
		int incr = 1;
		for (int i = 0; i < n; i++) {
			while (!count.compareAndSet(incr, incr + 1)) {
				this.wait();
			}
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			incr += 2;
			this.notifyAll();
		}
	}

	public static void main(String[] args) {
		FooBarAtomic a = new FooBarAtomic(2);
		new Thread(() -> {
			try {
				a.foo(() -> {
					System.out.print("foo");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				a.bar(() -> {
					System.out.print("bar");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

	}
}
