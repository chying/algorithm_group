package algorithm.chapter3.exe.binsearch;

/**
 * 【367. 有效的完全平方数】给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。 示例 1： 输入：16 输出：True 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class ValidPerfectSquare {
	/**
	 * 牛顿迭代法
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
//		int r = num;
//		if (num > 0) {
//			if (num == 1) {
//				return true;
//			}
//			while (r * r > num) {
//				r = (r + num / r) / 2;
//			}
//		}
//		return r * r == num;
		if (num == 1)
			return true;
		int cur = num / 2;
		while (!(cur * cur <= num && (cur + 1) * (cur + 1) > num)) {
			cur = cur - (cur * cur - num) / (2 * cur);
		}
		return cur * cur == num;

	}

	public static void main(String[] args) {
		ValidPerfectSquare a = new ValidPerfectSquare();
		int num = 808201;
		System.out.println(a.isPerfectSquare(num));
	}
}
