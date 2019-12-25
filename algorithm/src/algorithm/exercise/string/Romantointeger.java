package algorithm.exercise.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 【13. 罗马数字转整数】https://leetcode-cn.com/problems/roman-to-integer/
 * 
 * @author chying
 *
 */
public class Romantointeger {
	/**
	 * I 1 V 5 X 10 L 50 C 100 D 500 M 1000
	 * 
	 */
	static Map<String, Integer> map = new HashMap<>();
	static {
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);
	}

	static Map<Character, Integer> map_c = new HashMap<>();
	static {
		map_c.put('I', 1);
		map_c.put('V', 5);
		map_c.put('X', 10);
		map_c.put('L', 50);
		map_c.put('C', 100);
		map_c.put('D', 500);
		map_c.put('M', 1000);
	}

	/**
	 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40和90。 
	 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length();) {
			char ch = s.charAt(i);
			if ((ch == 'I' || ch == 'X' || ch == 'C') && i + 1 < s.length()) {
				String subStr = s.substring(i, i + 2);
				if (map.containsKey(subStr)) {
					result += map.get(subStr);
					i += 2;
					continue;
				}
			}
			result += map.get(String.valueOf(ch));
			i++;

		}
		return result;
	}

	public int romanToInt_fancy(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (i + 1 < s.length() && map_c.get(ch) < map_c.get(s.charAt(i + 1))) {
				result -= map_c.get(ch);
			} else {
				result += map_c.get(ch);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		Romantointeger a = new Romantointeger();
//		String s = new String("IV");
		String s = new String("III");
		System.out.println(a.romanToInt_fancy(s));
	}
}
