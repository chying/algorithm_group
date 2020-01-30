package thread.thediningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers1 {
	Lock[] locks = { new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
			new ReentrantLock() };

	public DiningPhilosophers1() {

	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
			Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
		int left = philosopher;
		int right = (philosopher + 1) % 5;
		if (philosopher % 2 == 0) {
			locks[left].lock();
			locks[right].lock();
		} else {
			locks[right].lock();
			locks[left].lock();
		}
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		putRightFork.run();
		locks[left].unlock();
		locks[right].unlock();
	}
}