package asyn;

import java.util.concurrent.CompletableFuture;

/**
 * 账户服务
 */
public interface AccountService {
	/**
	 * 变更账户金额
	 * 
	 * @param account 账户ID
	 * @param amount  增加的金额，负值为减少
	 */
	CompletableFuture<Void> add(int account, int amount);
}