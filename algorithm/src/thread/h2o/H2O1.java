package thread.h2o;

import java.util.concurrent.Semaphore;

class H2O1 {

	Semaphore h = new Semaphore(2);
	Semaphore o = new Semaphore(0);

	public H2O1() {
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		h.acquire();
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		releaseHydrogen.run();
		o.release();
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		o.acquire(2);
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		h.release(2);
	}

	public static void main(String[] args) {
		H2O1 a = new H2O1();
		new Thread(() -> {
			try {
				a.hydrogen(() -> {
					System.out.print("H");
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				a.oxygen(() -> {
					System.out.print("O");
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}