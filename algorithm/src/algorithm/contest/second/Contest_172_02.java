package algorithm.contest.second;

import java.util.ArrayList;
import java.util.List;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class Contest_172_02 {
	public List<String> printVertically(String s) {
		List<String> res = new ArrayList<>();
		if (null != s) {
			String[] arr = s.split("\\s+");
			int maxLen = 0;
			for (int i = 0; i < arr.length; i++) {
				maxLen = Math.max(maxLen, arr[i].length());
			}
			for (int i = 0; i < maxLen; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr[j].length() <= i ? ' ' : arr[j].charAt(i));
				}
				res.add(sb.toString().replaceFirst("\\s+$", ""));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Contest_172_02 a = new Contest_172_02();
		String s = "TO BE OR NOT TO BE";
		System.out.println(a.printVertically(s));
	}

}
