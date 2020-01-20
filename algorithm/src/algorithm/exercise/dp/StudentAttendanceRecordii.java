package algorithm.exercise.dp;

/**
 * 【552. 学生出勤记录 II】
 * https://leetcode-cn.com/problems/student-attendance-record-ii/
 * 多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
 * @author chying
 *
 */
public class StudentAttendanceRecordii {

	public int checkRecord(int n) {
		if (n > 0) {
			int[] dp = new int[n + 1];
			dp[0] = 0;
			
		}
		return 0;
	}

	public static void main(String[] args) {
		StudentAttendanceRecordii a = new StudentAttendanceRecordii();
	}
}
