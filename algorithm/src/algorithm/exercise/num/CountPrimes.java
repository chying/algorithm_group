package algorithm.exercise.num;

/**
 * 【204. 计数质数】https://leetcode-cn.com/problems/count-primes/
 * 
 * @author chying
 *
 */
public class CountPrimes {

	public int countPrimes(int n) {
		if (n < 3)
			return 0;
		boolean[] f = new boolean[n];
		// Arrays.fill(f, true); boolean[] are initialed as false by default
		int count = n / 2;
		for (int i = 3; i * i < n; i += 2) {
			if (f[i])
				continue;

			for (int j = i * i; j < n; j += 2 * i) {
				if (!f[j]) {
					--count;
					f[j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountPrimes a = new CountPrimes();
	}
}
