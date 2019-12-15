package algorithm.chapter2.exe.backtrace;

/**
 * 【50.powerN】实现 pow(x, n) ，即计算 x 的 n 次幂函数。 示例 1: 输入: 2.00000, 10 输出: 1024.00000
 * https://leetcode-cn.com/problems/powx-n/
 * 
 * @author chying
 *
 */
public class PowxN {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double result = 0;
		if (n < 0) {
			x = 1 / x;
			result = n % 2 == 0 ? myPow(x * x, -(n / 2)) : myPow(x * x, -(n / 2)) * x;
			return result;
		}

		result = n % 2 == 0 ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
		return result;
	}

	public static void main(String[] args) {
		PowxN a = new PowxN();
		System.out.println(a.myPow1(34.00515, -3));
	}

	public double myPow1(double x, int n) {
		double result = 0.0;
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			x = 1 / x;
			result = n % 2 == 0 ? myPow1(x * x, -(n / 2)) : x * myPow1(x * x, -(n / 2));
			return result;
		}

		result = n % 2 == 0 ? myPow1(x * x, n / 2) : x * myPow1(x * x, n / 2);
		return result;
	}
}
