package algorithm.chapter6.exe.sudoku;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n 是一个正整数。
 * 示例 1： 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ClimbStair {

	public int climbStairs(int n) {
		int[] cache = new int[n + 1];
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		return climbStairs(0, n, cache);
	}

	private int climbStairs(int i, int n, int[] cache) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		if (cache[i] != 0) {
			return cache[i];
		}
		cache[i] = climbStairs(i + 1, n, cache) + climbStairs(i + 2, n, cache);
		return cache[i];
	}

	public static void main(String[] args) {
		ClimbStair a = new ClimbStair();
		System.out.println(a.climbStairs(5));
	}
	
	
}
