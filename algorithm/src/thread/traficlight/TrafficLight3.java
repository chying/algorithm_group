package thread.traficlight;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TrafficLight3 {
	// 其实只要控制红灯这个竞态条件
	// 刚开始，lock和lightStatus变量我都设置成static，结果报错，按题意，对象级别的锁就可以了
	private final Lock lock = new ReentrantLock();
	private boolean lightStatus = true; // 一开始就是A路绿灯

	public TrafficLight3() {

	}

	public void carArrived(int carId, // ID of the car
			int roadId, // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
			int direction, // Direction of the car
			Runnable turnGreen, // Use turnGreen.run() to turn light to green on current road
			Runnable crossCar // Use crossCar.run() to make car cross the intersection
	) {
		System.out.printf("carId=%d, roadId=%d, direction=%d \n", carId, roadId, direction);
		lock.lock();
		try {
			if ((roadId == 1 && lightStatus == false) || (roadId == 2 && lightStatus == true)) {
				lightStatus = !lightStatus;
				turnGreen.run();
			}
			crossCar.run();
		} finally {
			lock.unlock();
		}
	}
}
