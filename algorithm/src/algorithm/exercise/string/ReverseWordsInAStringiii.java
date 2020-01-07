package algorithm.exercise.string;

/**
 * 【557. 反转字符串中的单词 III】
 * 
 * @author chying
 *
 */
public class ReverseWordsInAStringiii {
	public String reverseWords(String s) {
		if (null != s && s.length() > 0) {
			String[] arr = s.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				if (!arr[i].equals("")) {
					arr[i] = reverseStr(arr[i]);
				}
				if (i == arr.length - 1) {
					sb.append(arr[i]);
				} else {
					sb.append(arr[i] + " ");
				}
			}
			return sb.toString();
		}
		return null;
	}

	private String reverseStr(String val) {
		char[] chArr = val.toCharArray();
		for (int i = 0, j = chArr.length - 1; i < j; i++, j--) {
			char temp = chArr[i];
			chArr[i] = chArr[j];
			chArr[j] = temp;
		}
		return String.valueOf(chArr);
	}

	public static void main(String[] args) {
		ReverseWordsInAStringiii a = new ReverseWordsInAStringiii();
		String s = "  Let's take LeetCode   contest";
		System.out.println(a.reverseWords_1(s));
	}

	public String reverseWords_1(String s) {
		if (null != s && s.length() > 0) {
			int begin = 0;
			char[] chArr = s.toCharArray();
			for (int i = 1; i < chArr.length; i++) {
				if (chArr[i] == ' ') {
					swap(chArr, begin, i - 1);
					begin = i + 1;
				}
			}
			swap(chArr, begin, chArr.length-1);
			return String.valueOf(chArr);
		}
		return s;
	}

	private void swap(char[] chArr, int begin, int end) {
		for (int i = begin, j = end; i < j; i++, j--) {
			char temp = chArr[i];
			chArr[i] = chArr[j];
			chArr[j] = temp;
		}
	}
}
