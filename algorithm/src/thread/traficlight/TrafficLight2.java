package thread.traficlight;

import java.util.concurrent.Semaphore;

class TrafficLight2 {
//	ReentrantLock lock = new ReentrantLock();
//	Condition a = lock.newCondition();
//	Condition b = lock.newCondition();
	int[] cars = new int[] { 1, 2, 3, 4, 5 };
	int[] directions = new int[] { 2, 4, 3, 3, 1 };
	int[] arrivalTimes = new int[] { 10, 20, 30, 40, 40 };
	Semaphore a = new Semaphore(1);
	Semaphore b = new Semaphore(0);
	private volatile int n = 0;

	public TrafficLight2() {
		n = cars.length;
	}

	public void carArrived(int carId, // ID of the car
			int roadId, // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
			int direction, // Direction of the car
			Runnable turnGreen, // Use turnGreen.run() to turn light to green on current road
			Runnable crossCar // Use crossCar.run() to make car cross the intersection
	) throws InterruptedException {
		a.acquire();
		turnGreen.run();
		crossCar.run();

	}

	public static void main(String[] args) {
		TrafficLight2 a = new TrafficLight2();
//		cars = [1,2,3,4,5], directions = [2,4,3,3,1], arrivalTimes = [10,20,30,40,40]
	}
}