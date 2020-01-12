package algorithm.exercise.dp.again;

/**
 * ��276. դ��Ϳɫ�� https://leetcode-cn.com/problems/paint-fence/ k ����ɫ��Ϳ�Ϻ� n ��դ������դ��
 * 
 * @author chying
 *
 */
public class PaintFence {

	public int numWays(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
		if (n == 2) {
			return k * (k - 1) + k;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		// 1��դ������ k��Ϳɫ����
		dp[1] = k;
		// ����դ����Ϳ��ͬ��ɫ k*(k-1) Ϳ��ͬ��ɫk
		dp[2] = k * (k - 1) + k;
		for (int i = 3; i <= n; i++) {
			// ��i��դ�� ��ǰһ�� Ϳ��ͬ��ɫ ����ǰһ�� Ϳ��ͬ��ɫ
			dp[i] = dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1);
		}

		return dp[n];
	}

	public static void main(String[] args) {
		PaintFence a = new PaintFence();
		int k = 2;
		int n = 3;
		System.out.println(a.numWays(n, k));
	}
}
