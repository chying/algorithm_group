package algorithm.exercise.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【403. 青蛙过河】 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。
 * 青蛙可以跳上石头，但是不可以跳入水中。
 * 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * 请注意： 石子的数量 ≥ 2 且 < 1100； 每一个石子的位置序号都是一个非负整数，且其 < 231； 第一个石子的位置永远是0。 示例 1:
 * [0,1,3,5,6,8,12,17] 总共有8个石子。 第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置,
 * 第三个石子在序号为3的单元格的位置， 以此定义整个数组... 最后一个石子处于序号为17的单元格的位置。 返回
 * true。即青蛙可以成功过河，按照如下方案跳跃： 跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着 跳2个单位到第4块石子,
 * 然后跳3个单位到第6块石子, 跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class FrogJump {
	public boolean canCross(int[] stones) {
		if (null != stones) {
			int[] k = new int[] { 0, 1, 2 };
			// 青蛙站在第1个石子,序号0
			Deque<Integer> deque = new ArrayDeque<>();
			deque.add(1);
			int index = 1;
			int distance = 1;
			int pre = 0;
			while (!deque.isEmpty()) {
				int size = deque.size();
				for (int i = 0; i < size; i++) {
					distance = Math.max(distance, deque.poll());
					if (distance >= stones.length) {
						return true;
					}
				}
				while (index < stones.length && stones[index] - stones[pre] >= distance) {
					index++;
					deque.add(stones[index]);
				}
				pre = index;
			}
			if (distance < stones.length) {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		FrogJump a = new FrogJump();
		int[] stones = new int[] { 0, 1, 2, 3, 4, 5, 6, 12 };
//		/[0,1,2,3,4,5,6,12]
		System.out.println(a.canCross1(stones));
	}

	public boolean canCross1(int[] stones) {
		if (null != stones) {
			// 只能跳1个单位
			int[] k = new int[3];
			int pre = 0;
			int loc = 1;
			if (stones.length == 1) {
				return true;
			}
			if (stones.length == 2 && stones[1] > 1) {
				return false;
			}
			Deque<Integer> deque = new ArrayDeque<>();
			deque.add(1);
			while (!deque.isEmpty()) {
				int size = deque.size();
				for (int i = 0; i < size; i++) {
					loc = deque.poll();
					if (loc == stones.length - 1) {
						return true;
					}
					k[0] = loc - pre - 1;
					k[1] = loc - pre;
					k[2] = loc - pre + 1;
					for (int j = loc + 1; j < stones.length; j++) {
						int distance = stones[j] - stones[loc];
						if (distance == k[2]) {
//							for (int num : k) {
//								if (distance == num) {
									deque.add(j);
//								}
//							}
						} else {
							break;
						}
					}
				}
			}
		}
		return false;
	}
}
