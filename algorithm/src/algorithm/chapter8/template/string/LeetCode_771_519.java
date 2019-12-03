package algorithm.chapter8.template.string;

/**
 * 【771. 宝石与石头】
 * 
 * @author chying
 *
 */
public class LeetCode_771_519 {

	public int numJewelsInStones(String J, String S) {
		int res = 0;
		for (char c : S.toCharArray()) {
			if (J.indexOf(c) != -1) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LeetCode_771_519 a = new LeetCode_771_519();
	}
}
