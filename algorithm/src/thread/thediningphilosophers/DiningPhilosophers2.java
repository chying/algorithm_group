package thread.thediningphilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers2 {
	private ReentrantLock[] locks = { new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
			new ReentrantLock(), new ReentrantLock() };
	private Semaphore sem;

	public DiningPhilosophers2() {

		sem = new Semaphore(4);
	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
			Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {

		sem.acquire();
		int leftFork = philosopher;
		int rightFork = (philosopher + 1) % 5;
		locks[leftFork].lock();
		locks[rightFork].lock();
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		putRightFork.run();
		locks[leftFork].unlock();
		locks[rightFork].unlock();
		sem.release();

	}
}
