package algorithm.exercise;

/**
 * ��461. �������롿https://leetcode-cn.com/problems/hamming-distance/
 * 
 * @author chying
 *
 */
public class HammingDistance {
	/**
	 * ������һ��1
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
		int n = 0;
		int val = x ^ y;
		while (val != 0) {
			val &= (val - 1);
			n++;
		}
		return n;
	}

	public static void main(String[] args) {
		HammingDistance a = new HammingDistance();
		System.out.println(a.hammingDistance(1, 4));
	}
}
