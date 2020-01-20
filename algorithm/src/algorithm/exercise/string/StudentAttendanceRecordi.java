package algorithm.exercise.string;

/**
 * 【551. 学生出勤记录 I】 https://leetcode-cn.com/problems/student-attendance-record-i/
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
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
	 * . : 匹配任何除了换行以外的单个字符。 : 匹配 0 个或者 大于 0 个 * 符号前面的表达式。 .* : 匹配任何字符串 a|b : 要么匹配 a
	 * 要么匹配 b
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
