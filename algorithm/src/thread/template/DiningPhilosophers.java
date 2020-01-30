package thread.template;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

	Semaphore sem = new Semaphore(3);
	Lock[] locks = { new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
			new ReentrantLock() };

	public DiningPhilosophers() {

	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
			Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {

		sem.acquire();
		int left = philosopher;
		int right = (philosopher + 1) % 5;
		locks[left].lock();
		locks[right].lock();
		try {
			pickLeftFork.run();
			pickRightFork.run();
			eat.run();
			putLeftFork.run();
			putRightFork.run();
		} finally {
			locks[left].unlock();
			locks[right].unlock();
			sem.release();
		}

	}

	public static void main(String[] args) {
		DiningPhilosophers a = new DiningPhilosophers();
//		a.wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
	}
}