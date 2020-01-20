package algorithm.exercise.string;

/**
 * ��551. ѧ�����ڼ�¼ I�� https://leetcode-cn.com/problems/student-attendance-record-i/
 * ���һ��ѧ���ĳ��ڼ�¼�в�����һ��'A'(ȱ��)���Ҳ���������������'L'(�ٵ�),��ô���ѧ���ᱻ���͡�
 * 
 * @author chying
 *
 */
public class StudentAttendanceRecordi {

	public boolean checkRecord(String s) {
		int counta = 0;
		int countl = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'A') {
				counta++;
				if (counta > 1) {
					return false;
				}
			} else if (ch == 'L') {
				countl++;
				if (countl > 2) {
					return false;
				}
			}
			if (ch != 'L') {
				countl = 0;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		StudentAttendanceRecordi a = new StudentAttendanceRecordi();
		String s = "LALL";
		System.out.println(a.checkRecord(s));
	}

	/**
	 * . : ƥ���κγ��˻�������ĵ����ַ��� : ƥ�� 0 ������ ���� 0 �� * ����ǰ��ı��ʽ�� .* : ƥ���κ��ַ��� a|b : Ҫôƥ�� a
	 * Ҫôƥ�� b
	 * 
	 * @param s
	 * @return
	 */

	public boolean checkRecord_Rex(String s) {
		String regex = ".*(A.*A|LLL).*";
//		/!s.matches(".*(A.*A|LLL).*");
		return !s.matches(regex);
	}
}
