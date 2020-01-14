package algorithm.chapter3.first.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【45. 跳跃游戏 II】给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 示例: 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。  
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class JumpGameii {
	public int jump(int[] nums) {
		if (null != nums && nums.length > 0) {
			if (nums.length == 1) {
				return 0;
			}
			int count = 0;
			Deque<Integer> deque = new ArrayDeque<Integer>();
			deque.add(0);
			int distance = nums.length - 1;
			while (!deque.isEmpty()) {
				int size = deque.size();
				count++;
				for (int i = 0; i < size; i++) {
					int jumpIndex = deque.poll();
					for (int j = nums[jumpIndex]; j > 0; j--) {
						if (jumpIndex + j >= distance) {
							return count;
						}
						deque.add(jumpIndex + j);
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		JumpGameii a = new JumpGameii();
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		System.out.println(a.jump2(nums));
	}

	public int jump2(int[] nums) {
		int position = nums.length - 1; // 要找的位置
		int steps = 0;
		while (position != 0) { // 是否到了第 0 个位置
			for (int i = 0; i < position; i++) {
				if (nums[i] >= position - i) {
					position = i; // 更新要找的位置
					steps++;
					break;
				}
			}
		}
		return steps;
	}

}
