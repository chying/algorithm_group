package algorithm.chapter3.first.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 【874. 模拟行走机器人】机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * -2：向左转 90 度 -1：向右转 90 度 1 <= x <= 9：向前移动 x 个单位长度 在网格上有一些格子被视为障碍物。 第
 * i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 返回从原点到机器人的最大欧式距离的平方。 示例
 * 1： 输入: commands = [4,-1,3], obstacles = [] 输出: 25 解释: 机器人将会到达 (3, 4)
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_874_519 {

	private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int robotSim(int[] commands, int[][] obstacles) {

		Set<String> obstaclesRowToCols = new HashSet<>();
		for (int[] obstacle : obstacles) {
			obstaclesRowToCols.add(obstacle[0] + " " + obstacle[1]);
		}

		int x = 0, y = 0, direction = 1, maxDistSquare = 0;
		for (int i = 0; i < commands.length; i++) {
			if (commands[i] == -2) {
				direction--;
				if (direction < 0) {
					direction += 4;
				}
			} else if (commands[i] == -1) {
				direction++;
				direction %= 4;
			} else {
				int step = 0;
				while (step < commands[i] && (!obstaclesRowToCols
						.contains((x + directions[direction][0]) + " " + (y + directions[direction][1])))) {
					x += directions[direction][0];
					y += directions[direction][1];
					step++;
				}
			}
			maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
		}

		return maxDistSquare;
	}

	public static void main(String[] args) {

	}

}
