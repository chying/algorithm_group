package algorithm.exercise.num;

/**
 * 【7. 整数反转】https://leetcode-cn.com/problems/reverse-integer/
 * 
 * @author chying
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		if (x == 0 || x == Integer.MIN_VALUE)
			return 0;
		int num = 0;
		while (x % 10 != x) {
			num = num * 10 + x % 10;
			x /= 10;
			if (Integer.MAX_VALUE / 10 < num || Integer.MIN_VALUE / 10 > num) {
				return 0;
			} else if (Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 <= x % 10) {
				return 0;
			} else if (Integer.MIN_VALUE / 10 == num && Integer.MIN_VALUE % 10 >= x % 10) {
				return 0;
			}
		}
		num = num * 10 + x % 10;
		return num;
	}

	public static void main(String[] args) {
		ReverseInteger a = new ReverseInteger();
		System.out.println(a.reverse(Integer.MIN_VALUE % 10));
		System.out.println(a.reverse(-1463847412));
	}
}
