package algorithm.exercise.string;

/**
 * °æ171. Excel±Ì¡––Ú∫≈°øhttps://leetcode-cn.com/problems/excel-sheet-column-number/
 * 
 * @author chying
 *
 */
public class ExcelSheetcolumnnumber {
	public int titleToNumber(String s) {
		int result = 0;
		int[] num = new int[26];
		for (int i = 0; i < 26; i++) {
			num[i] = i + 1;
		}
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + num[s.charAt(i) - 'A'];
		}
		return result;
	}

	public static void main(String[] args) {
		ExcelSheetcolumnnumber a = new ExcelSheetcolumnnumber();
		System.out.println(a.titleToNumber("ZY"));
	}
}
