package algorithm.exercise.dp.exe;

/**
 * ��276. դ��Ϳɫ�� https://leetcode-cn.com/problems/paint-fence/
 * 
 * @author chying
 *
 */
public class PaintFence {
	/**
	 * ��ǰһ��դ��Ϳ��ͬ��ɫ��f(n-2)*(k-1) ��ǰһ��դ��Ϳ��ͬ��ɫ��f(n-1)*(k-1)
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int numWays(int n, int k) {
		if (n > 0 && k > 0) {
			int[] dp = new int[n + 1];
			if (n == 1) {
				return k;
			}
			if (n == 2) {
				return k + k * (k - 1);
			}
			dp[1] = k;
			// k�� ͬɫ��Ck2�� ��ͬ��ɫ
			dp[2] = k + k * (k - 1);
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
			}
			return dp[n];
		}
		return 0;
	}

	public static void main(String[] args) {
		PaintFence a = new PaintFence();
		System.out.println(a.numWays(3, 2));
	}
}
