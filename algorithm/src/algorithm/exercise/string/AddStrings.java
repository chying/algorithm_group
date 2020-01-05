package algorithm.exercise.string;

/**
 * ¡¾415. ×Ö·û´®Ïà¼Ó¡¿ https://leetcode-cn.com/problems/add-strings/
 * 
 * @author chying
 *
 */
public class AddStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder result = new StringBuilder();
		int i = num1.length() - 1, j = num2.length() - 1;
		int plus = 0;
		while (i >= 0 || j >= 0) {
			int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
			int sum = x + y + plus;
			plus = sum / 10;
			result.append(sum % 10);
		}
		if (plus == 1) {
			result.append(plus);
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		AddStrings a = new AddStrings();
		System.out.println(a.addStrings("12345", "453"));
	}
}
