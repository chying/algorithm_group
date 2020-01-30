package thread.traficlight;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TrafficLight3 {
	// ��ʵֻҪ���ƺ�������̬����
	// �տ�ʼ��lock��lightStatus�����Ҷ����ó�static��������������⣬���󼶱�����Ϳ�����
	private final Lock lock = new ReentrantLock();
	private boolean lightStatus = true; // һ��ʼ����A·�̵�

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
