package thread.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MyLog {
	// 已处理日志序号
	private static AtomicInteger outOrder = new AtomicInteger(0);
	// 已读入日志序号
	private static AtomicInteger inOrder = new AtomicInteger(0);

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		String logText1 = "";
		String logText2 = "";
		executorService.submit(new MyWork("我的任务1", logText1, inOrder.incrementAndGet()));
		executorService.submit(new MyWork("我的任务2", logText2, inOrder.incrementAndGet()));
		executorService.shutdown();
	}

	static class MyWork implements Runnable {
		// 任务名称
		private String name;
		// 原始日志内容
		private String logText;
		// 处理后输出顺序
		private Integer order;

		MyWork(String name, String logText, Integer order) {
			this.name = name;
			this.logText = logText;
			this.order = order;
		}

		@Override
		public void run() {
			// todo 日志处理
			// handleLog(logText);

			while (true) {
				if (order == outOrder.get() - 1) {
					// todo 处理结果按顺序写入新日志
					// outputLog(logText);
					outOrder.incrementAndGet(); // 已处理日志outOrder+1
					break;
				}
			}
		}
	}
}