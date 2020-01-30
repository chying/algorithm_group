package thread.foobar;

import java.util.concurrent.Semaphore;

public class FooBar {
	private int n;

	public FooBar(int n) {
		this.n = n;
	}

	Semaphore f = new Semaphore(1);
	Semaphore b = new Semaphore(0);

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			f.acquire();
			printFoo.run();
			b.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			b.acquire();
			printBar.run();
			f.release();
		}
	}

	public static void main(String[] args) {
		FooBar a = new FooBar(2);
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
