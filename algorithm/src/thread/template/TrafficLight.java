package thread.template;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TrafficLight {
	private volatile boolean Alight = true;
	Lock lock = new ReentrantLock();

	public TrafficLight() {

	}

	public void carArrived(int carId, // ID of the car
			int roadId, // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
			int direction, // Direction of the car
			Runnable turnGreen, // Use turnGreen.run() to turn light to green on current road
			Runnable crossCar // Use crossCar.run() to make car cross the intersection
	) {
		lock.lock();
		try {
			if ((roadId == 1 && !Alight) || (roadId == 2 && Alight)) {
				Alight = !Alight;
				turnGreen.run();
			}
			crossCar.run();
		} finally {
			lock.unlock();
		}
	}
}