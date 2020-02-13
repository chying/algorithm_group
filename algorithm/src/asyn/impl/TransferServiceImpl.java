package asyn.impl;

import java.util.concurrent.CompletableFuture;

import asyn.AccountService;
import asyn.TransferService;

/**
 * 转账服务的实现
 */
public class TransferServiceImpl implements TransferService {

//	@Autowired
	private AccountService accountService; // 使用依赖注入获取账户服务的实例

	@Override
	public CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount) {
		// 异步调用add方法从fromAccount扣减相应金额
		return accountService.add(fromAccount, -1 * amount)
				// 然后调用add方法给toAccount增加相应金额
				.thenCompose(v -> accountService.add(toAccount, amount));
	}
}
