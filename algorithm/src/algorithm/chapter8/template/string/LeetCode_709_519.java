package algorithm.chapter8.template.string;

/**
 * ��709. ת����Сд��ĸ��
 * 
 * @author chying
 *
 */
public class LeetCode_709_519 {
	public String toLowerCase(String str) {
		if(null!=str) {
			str=str.toLowerCase();
		}
		return str;
	}

	public static void main(String[] args) {
		LeetCode_709_519 a = new LeetCode_709_519();
		System.out.println(a.toLowerCase("Strig"));
	}
}
