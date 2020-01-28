package thread.printinorder;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		FooC a = new FooC();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					a.first(new Test().new MyRun("first"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					a.third(new Test().new MyRun("third"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					a.second(new Test().new MyRun("second"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t3.start();
		t2.start();

	}

	class MyRun implements Runnable {

		private String printVal;

		MyRun(String printVal) {
			this.printVal = printVal;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(printVal);
		}
	}
}
