package algorithm.exercise.num;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if (n == 1)
			return true;
		int r = 0;
		while (n > 3 && r == 0) {
			r = n % 3;
			n /= 3;
		}
		return n == 3 && r == 0;
	}

	public static void main(String[] args) {
		PowerOfThree a = new PowerOfThree();
		System.out.println(a.isPowerOfThree_bit(27));
	}

	public boolean isPowerOfThree_bit(int n) {
		if (n == 1)
			return true;
		int tmp = 1;
		while (tmp < n) {
			tmp = (tmp << 1) + tmp;
		}
		return n == tmp;
	}
}
