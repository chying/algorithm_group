package algorithm.chapter3.first.binarysearch;

/**
 * 【69. x 的平方根】实现 int sqrt(int x) 函数。 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 示例 1: 输入: 4 输出: 2 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class Sqrtx {

	public int mySqrt2(int x) {
		if (0 == x)
			return 0;
		int left = 1, right = x, ans = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid <= x / mid) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	/**
	 * 牛顿迭代法
	 * 
	 * @param x
	 * @return
	 */
	public int mySqrt3(int x) {
		long r = x;
		while (r * r > x)
			r = (r + x / r) / 2;
		return (int) r;
	}

	/**
	 * 牛顿迭代法
	 * 
	 * @param x
	 * @return
	 */
	public int mySqrt4(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = x;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}

	public static void main(String[] args) {
		Sqrtx a = new Sqrtx();
		System.out.println(a.mySqrt4(3));

	}
}
