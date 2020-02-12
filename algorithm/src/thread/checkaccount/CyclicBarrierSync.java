package thread.checkaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierSync {
	// 订单队列
	static Vector<String> pos = new Vector<>();
	// 派送单队列
	static Vector<String> dos = new Vector<>();
	// 异常
	static List<String> store = new ArrayList<>();

	static AtomicInteger pnum = new AtomicInteger(0);
	static AtomicInteger dnum = new AtomicInteger(0);

	public static void main(String[] args) {

//		CompletableFuture<List> pOrderFuture = CompletableFuture.supplyAsync(this::getPOrders);
//		CompletableFuture<List> dOrderFuture = CompletableFuture.supplyAsync(this::getDOrders);
//		pOrderFuture.thenCombine(dOrderFuture, this::check).thenAccept(this::save);
	}

	private static String getDOrders() {
		return String.valueOf(dnum.getAndIncrement());
	}

	private static String getPOrders() {
		return String.valueOf(pnum.getAndIncrement());
	}
}
