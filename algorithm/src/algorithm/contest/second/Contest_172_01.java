package algorithm.contest.second;

/**
 * ¡¾¡¿
 * 
 * @author chying
 *
 */
public class Contest_172_01 {

	public int maximum69Number(int num) {
		String a = String.valueOf(num);
		char[] arr = a.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '6') {
				arr[i] = '9';
				return Integer.parseInt(String.valueOf(arr));
			}
		}
		return num;
	}

	public static void main(String[] args) {
		Contest_172_01 a = new Contest_172_01();
		System.out.println(a.maximum69Number(699));
	}

}
