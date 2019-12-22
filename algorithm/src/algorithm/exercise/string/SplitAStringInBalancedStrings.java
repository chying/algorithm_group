package algorithm.exercise.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 返回可以通过分割得到的平衡字符串的最大数量。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class SplitAStringInBalancedStrings {

	public static void main(String[] args) {
		SplitAStringInBalancedStrings a = new SplitAStringInBalancedStrings();
		String s = "RLRRLLRLRL";
		System.out.println(a.balancedStringSplit1(s));
	}

	public int balancedStringSplit1(String s) {
		int n = 0;
		if (null != s && s.length() > 0) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'L') {
					count++;
				} else {
					count--;
				}
				if (count == 0) {
					n++;
				}
			}
		}
		return n;
	}

}
