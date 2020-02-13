package asyn.impl;

import java.util.concurrent.CompletableFuture;

import asyn.AccountService;
import asyn.TransferService;

/**
 * ת�˷����ʵ��
 */
public class TransferServiceImpl implements TransferService {

//	@Autowired
	private AccountService accountService; // ʹ������ע���ȡ�˻������ʵ��

	@Override
	public CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount) {
		// �첽����add������fromAccount�ۼ���Ӧ���
		return accountService.add(fromAccount, -1 * amount)
				// Ȼ�����add������toAccount������Ӧ���
				.thenCompose(v -> accountService.add(toAccount, amount));
	}
}
