package algorithm.exercise.string;

/**
 * ¡¾443. Ñ¹Ëõ×Ö·û´®¡¿ https://leetcode-cn.com/problems/string-compression/
 * 
 * @author chying
 *
 */
public class StringCompression {
	public int compress(char[] chars) {
		if (null != chars && chars.length > 0) {
			if (chars.length == 1) {
				return 1;
			}
			int count = 1;
			int index = 0;
			char cur = chars[0];
			for (int i = 1; i < chars.length; i++) {
				if (cur == chars[i]) {
					count++;
				} else {
					char temp = chars[i];
					chars[index++] = cur;
					chars[index++] = (char) (count);
					count = 1;
					cur = temp;
				}
			}
			chars[index++] = chars[chars.length - 1];
			chars[index++] = (char) (count);
			return index;
		}
		return 0;
	}

	public static void main(String[] args) {
		StringCompression a = new StringCompression();
		char[] chars = new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		System.out.println(a.compress(chars));
	}

}
