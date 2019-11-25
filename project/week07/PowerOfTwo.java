package algorithm.chapter7.first;

/**
 * 【power-of-two】给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 示例 1: 输入: 1 输出: true 解释: 20 = 1
 * https://leetcode-cn.com/problems/power-of-two/
 * 
 * @author chying
 *
 */
public class PowerOfTwo {
	/**
	 * 有且仅有一个二进制位是1
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		PowerOfTwo a = new PowerOfTwo();
	}
}
