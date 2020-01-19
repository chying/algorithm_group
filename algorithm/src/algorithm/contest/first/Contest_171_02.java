package algorithm.contest.first;

/**
 * 【5308. 或运算的最小翻转次数】 给你三个正整数 a、b 和 c。
 * 
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算 a OR b == c 成立的最小翻转次数。
 * 
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * 
 * 
 * 
 * @author chying
 *
 */
public class Contest_171_02 {
	public int minFlips(int a, int b, int c) {
		int count = 0;
		String aStr = getBit(a);
		String bStr = getBit(b);
		String cStr = getBit(c);
		int i = aStr.length() - 1, j = bStr.length() - 1, k = cStr.length() - 1;
		while (i >= 0 || j >= 0 || k >= 0) {
			char aCh = i >= 0 ? aStr.charAt(i--) : '0';
			char bCh = j >= 0 ? bStr.charAt(j--) : '0';
			char cCh = k >= 0 ? cStr.charAt(k--) : '0';
			if (cCh == '1') {
				if (aCh == bCh && aCh == '0') {
					count++;
				}
			} else {
				if (aCh == bCh && aCh == '1') {
					count += 2;
				} else {
					if (aCh != bCh) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private String getBit(int num) {
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(num % 2);
			num /= 2;
		}
		return sb.reverse().toString();
	}

	public int minFlips_2(int a, int b, int c) {
		int result = 0;
		while (a != 0 || b != 0 || c != 0) {
			int nc = c & 1, na = a & 1, nb = b & 1;
			result += nc == 1 ? ((na == 0 && nb == 0) ? 1 : 0) : na + nb;
			c >>= 1;
			a >>= 1;
			b >>= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		Contest_171_02 a = new Contest_171_02();
		System.out.println(a.minFlips_2(1, 2, 3));
	}

	public int minFlips_1(int a, int b, int c) {
		int res = 0;
		for (int i = 0; i < 31; i++) {
			int nc = (c >> i) & 1;
			int na = (a >> i) & 1;
			int nb = (b >> i) & 1;
			if (nc > 0) {
				if (na == 0 && nb == 0)
					res++;
			} else {
				res += na + nb;
			}
		}
		return res;
	}
}
