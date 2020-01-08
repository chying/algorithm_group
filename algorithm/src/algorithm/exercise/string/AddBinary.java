package algorithm.exercise.string;

/**
 * 【67. 二进制求和】 https://leetcode-cn.com/problems/add-binary/
 * 
 * @author chying
 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || carry == 1) {
			int x = i >= 0 && a.charAt(i) == '1' ? 1 : 0;
			int y = j >= 0 && b.charAt(j) == '1' ? 1 : 0;
			int sum = x + y + carry;
			carry = sum / 2;
			sb.append(sum % 2);
			i--;
			j--;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinary a1 = new AddBinary();
		String a = "1010", b = "1011";
//		?"1010"
//				"1011"
		System.out.println(a1.addBinary(a, b));
	}
}
