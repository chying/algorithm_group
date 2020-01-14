package algorithm.chapter3.first.greedy;

/**
 * 【55. 跳跃游戏】给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。 示例 1: 输入: [2,3,1,1,4] 输出: true 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1,
 * 然后再从位置 1 跳 3 步到达最后一个位置。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		if (null != nums) {
			int position = nums.length - 1;
			if (position == 0) {
				return true;
			}
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] + i >= position) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGame a = new JumpGame();
		int[] nums = new int[] { 0, 2, 3 };
		System.out.println(a.canJump2(nums));
	}

	public boolean canJump2(int[] nums) {
		int position = nums.length - 1; // 要找的位置
		while (position != 0) { // 是否到了第 0 个位置
			for (int i = 0; i < position; i++) {
				if (nums[i] >= position - i) {
					position = i; // 更新要找的位置
					break;
				}
			}
		}
		return true;
	}
}
