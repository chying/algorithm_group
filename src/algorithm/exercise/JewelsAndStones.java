package algorithm.exercise;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		char[] sar = S.toCharArray();
		char[] jar = J.toCharArray();
		Set<Character> set = new HashSet<>();
		int result = 0;
		for (char c : jar) {
			set.add(c);
		}
		for (char c : sar) {
			if (set.contains(c)) {
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		JewelsAndStones a=new JewelsAndStones();
		System.out.println(a.numJewelsInStones("aA", "aAAbbbb"));
	}
}
