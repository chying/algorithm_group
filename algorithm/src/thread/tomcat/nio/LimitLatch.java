package thread.tomcat.nio;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 连接控制器,最大连接数 NIO模式下 default：1w
 * 
 * @author chying
 *
 */
public class LimitLatch {
	private final Sync sync;
	private final AtomicLong count;
	private volatile long limit;

	public LimitLatch(long limit) {
		this.limit = limit;
		this.count = new AtomicLong(0);
		this.sync = new Sync();
	}

	private class Sync extends AbstractQueuedSynchronizer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected int tryAcquireShared(int ignored) {
			long newCount = count.incrementAndGet();
			if (newCount > limit) {
				count.decrementAndGet();
				return -1;
			}
			return 1;
		}

		@Override
		protected boolean tryReleaseShared(int arg) {
			count.decrementAndGet();
			return true;
		}
	}

	// 线程调用这个方法来获得接收新连接的许可，线程可能被阻塞
	public void countUpOrAwait() throws InterruptedException {
		sync.acquireSharedInterruptibly(1);
	}

	// 调用这个方法来释放一个连接许可，前面阻塞的线程可能被唤醒
	public long countDown() {
		sync.releaseShared(0);
		long result = getCount();
		return result;
	}

	public long getCount() {
		return count.get();
	}
}
