package asyn;

import java.util.concurrent.CompletableFuture;

/**
 * ת�˷���
 */
public interface TransferService {
	/**
	 * �첽ת�˷���
	 * 
	 * @param fromAccount ת���˻�
	 * @param toAccount   ת���˻�
	 * @param amount      ת�˽���λ��
	 */
	CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount);
}