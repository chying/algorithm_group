package algorithm.chapter4.template;

import java.util.Arrays;

/**
 * 【62. 不同路径】一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 问总共有多少条不同的路径？ 例如，上图是一个7 x 3
 * 的网格。有多少可能的路径？ 说明：m 和 n 的值均不超过 100。 示例 1: 输入: m = 3, n = 2 输出: 3 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。 1. 向右 -> 向右 -> 向下 2. 向右 -> 向下 -> 向右 3. 向下 -> 向右 ->
 * 向右
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class UniquePaths {

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

	public int uniquePaths1(int m, int n) {
		int[] cur = new int[n];
		Arrays.fill(cur, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				cur[j] += cur[j - 1];
			}
		}
		return cur[n - 1];
	}

	public static void main(String[] args) {
		UniquePaths a = new UniquePaths();
		System.out.println(a.uniquePaths(3, 2));
	}

	/**
	 * 68.72%
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}
