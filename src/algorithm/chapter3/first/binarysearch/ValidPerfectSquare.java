package algorithm.chapter3.first.binarysearch;

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
	// 正整数 大于0的整数
	public boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		int left = 0, right = num;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (mid > 0) {
				if (num == mid * mid) {
					return true;
				} else {
					if (num / mid > mid) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			} else {
				return false;
			}

		}
		return false;
	}

	public boolean isPerfectSquare2(int x) {
		long r = x;
		while (r * r > x)
			r = (r + x / r) / 2;
		return r * r == x;
	}

	public static void main(String[] args) {
		ValidPerfectSquare a = new ValidPerfectSquare();
		System.out.println(a.isPerfectSquare(5));
	}
}
