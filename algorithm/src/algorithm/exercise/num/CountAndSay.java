package algorithm.exercise.num;

/**
 * ¡¾38. ±¨Êý¡¿https://leetcode-cn.com/problems/count-and-say/
 * 
 * @author chying
 *
 */
public class CountAndSay {

	public String countAndSay(int n) {
		String result = "1";
		for (int i = 1; i < n; i++) {
			char[] ch = result.toCharArray();
			char target = ch[0];
			int count = 0;
			String subResult = "";
			for (int j = 0; j < ch.length; j++) {
				if (target == ch[j]) {
					count++;
				} else {
					subResult += String.valueOf(count) + String.valueOf(target);
					target = ch[j];
					count = 1;
				}
			}
			result = subResult + String.valueOf(count) + String.valueOf(target);
		}
		return result;
	}

	public static void main(String[] args) {
		CountAndSay a = new CountAndSay();
		System.out.println(a.countAndSay(1));
	}
}
