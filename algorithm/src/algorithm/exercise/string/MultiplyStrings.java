package algorithm.exercise.string;

/**
 * 【43. 字符串相乘】
 * 
 * @author chying
 *
 */
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		if (null != num1 && null != num2) {
			// 常识 大数作为乘数 小数 被乘数
			int len1 = num1.length();
			int len2 = num2.length();
			int max = len1 > len2 ? len1 : len2;
			int min = len1 > len2 ? len2 : len1;
			char[] arrMax = len1 > len2 ? num1.toCharArray() : num2.toCharArray();
			char[] arrMin = len1 > len2 ? num2.toCharArray() : num1.toCharArray();
			int sum = 0;
			for (int i = min - 1; i >= 0; i--) {
				int x = arrMin[i] - '0';
				int zeroi = min - 1 - i;
				while (x != 0 && zeroi > 0) {
					x *= 10;
					zeroi--;
				}
				int temp = 0;
				for (int j = max - 1; j >= 0; j--) {
					int y = arrMax[j] - '0';
					int zeroj = max - 1 - j;
					while (y != 0 && zeroj > 0) {
						y *= 10;
						zeroj--;
					}
					temp += x * y;
				}
				sum += temp;
			}
			return String.valueOf(sum);
		}
		return null;
	}

	public static void main(String[] args) {
		MultiplyStrings a = new MultiplyStrings();
		System.out.println(10345 * 456);
		System.out.println(a.multiply("10345", "456"));
	}
}
