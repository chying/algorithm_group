package algorithm.exercise.dp.exe;

/**
 * 【276. 栅栏涂色】 https://leetcode-cn.com/problems/paint-fence/
 * 
 * @author chying
 *
 */
public class PaintFence {
	/**
	 * 和前一个栅栏涂相同颜色，f(n-2)*(k-1) 和前一个栅栏涂不同颜色，f(n-1)*(k-1)
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
			// k种 同色，Ck2种 不同颜色
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
