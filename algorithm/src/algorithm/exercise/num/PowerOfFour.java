package algorithm.exercise.num;

/**
 * ¡¾342. 4µÄÃÝ¡¿
 * 
 * @author chying
 *
 */
public class PowerOfFour {

	public boolean isPowerOfFour(int num) {
		if (num <= 0)
			return false;
		if ((num & (num - 1)) == 0) {
			int count = 0;
			while (num != 0) {
				num = num >> 1;
				count++;
			}
			return count % 2 == 1;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		PowerOfFour a = new PowerOfFour();
		System.out.println(a.isPowerOfFour(8));
	}
}
