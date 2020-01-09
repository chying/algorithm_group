package algorithm.exercise.string;

/**
 * 【657. 机器人能否返回原点】 https://leetcode-cn.com/problems/robot-return-to-origin/
 * 
 * @author chying
 *
 */
public class RobotReturnToOrigin {
	public boolean judgeCircle(String moves) {
		if (null != moves && moves.length() > 0) {
			int upCount = 0;
			int leftCount = 0;
			for (char ch : moves.toCharArray()) {
				if (ch == 'U') {
					upCount++;
				} else if (ch == 'D') {
					upCount--;
				} else if (ch == 'L') {
					leftCount++;
				} else if (ch == 'R') {
					leftCount--;
				}
			}
			return leftCount == 0 && upCount == 0;
		}
		return true;
	}

	public static void main(String[] args) {
		RobotReturnToOrigin a = new RobotReturnToOrigin();
		String s = "UDL";
		System.out.println(a.judgeCircle(s));
	}
}
