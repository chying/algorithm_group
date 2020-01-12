package algorithm.exercise.dp.again;

/**
 * 【276. 栅栏涂色】 https://leetcode-cn.com/problems/paint-fence/ k 种颜色的涂料和 n 个栅栏柱的栅栏
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
		// 1个栅栏，有 k种涂色方案
		dp[1] = k;
		// 两个栅栏，涂不同颜色 k*(k-1) 涂相同颜色k
		dp[2] = k * (k - 1) + k;
		for (int i = 3; i <= n; i++) {
			// 第i个栅栏 和前一个 涂相同颜色 ，和前一个 涂不同颜色
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
