package asyn;

import java.util.concurrent.CompletableFuture;

/**
 * �˻�����
 */
public interface AccountService {
	/**
	 * ����˻����
	 * 
	 * @param account �˻�ID
	 * @param amount  ���ӵĽ���ֵΪ����
	 */
	CompletableFuture<Void> add(int account, int amount);
}