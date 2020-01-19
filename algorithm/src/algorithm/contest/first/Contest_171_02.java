package algorithm.contest.first;

/**
 * ��5308. ���������С��ת������ �������������� a��b �� c��
 * 
 * ����Զ� a �� b �Ķ����Ʊ�ʾ����λ��ת�����������ܹ�ʹ��λ������ a OR b == c ��������С��ת������
 * 
 * ��λ��ת��������ָ��һ�����Ķ����Ʊ�ʾ�κε���λ�ϵ� 1 ��� 0 ���� 0 ��� 1 ��
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
