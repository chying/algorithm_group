package thread.foobar;

import java.util.concurrent.locks.LockSupport;

public class FooBarPackNanos {
	private int n;

	private volatile boolean foo;

	public FooBarPackNanos(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			while (foo) {
				LockSupport.parkNanos(1L);
			}

			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();

			foo = true;
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			while (!foo) {
				LockSupport.parkNanos(1L);
			}

			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();

			foo = false;

		}
	}

	public static void main(String[] args) {
		FooBarPackNanos a = new FooBarPackNanos(2);
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
