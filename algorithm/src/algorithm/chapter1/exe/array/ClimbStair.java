package algorithm.chapter1.exe.array;

/**
 * 【70.爬楼梯】假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n
 * 是一个正整数。 示例 1： 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ClimbStair {
	/**
	 * 记忆化递归
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		int memo[] = new int[n + 1];
		return climb_Stairs(0, n, memo);
	}

	public int climb_Stairs(int i, int n, int memo[]) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		if (memo[i] > 0) {
			return memo[i];
		}
		memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
		return memo[i];
	}

	public static void main(String[] args) {
		ClimbStair a = new ClimbStair();
		System.out.println(a.climbStairs_FB(5));
	}

	/**
	 * dp方程 dp[n] = dp[n - 1] + dp[n - 2];
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs_DP(int n) {
		if (n > 0) {
			if (n == 1 || n == 2) {
				return n;
			}
			int[] dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			return dp[n];
		}
		return 0;
	}

	public int climbStairs_FB(int n) {
		if (n > 0) {
			if (n == 1 || n == 2) {
				return n;
			}
			int first = 1;
			int second = 2;
			int third = 0;
			for (int i = 3; i <= n; i++) {
				third = first + second;
				first = second;
				second = third;
			}
			return third;
		}
		return 0;
	}
}
