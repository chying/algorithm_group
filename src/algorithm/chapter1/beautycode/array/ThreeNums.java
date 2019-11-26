package algorithm.chapter1.beautycode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【15.三数之和】给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 
 * @author chying
 *
 */
public class ThreeNums {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		int len = nums.length;
		if (nums == null || len < 3)
			return ans;
		Arrays.sort(nums); // 鎺掑簭
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0)
				break; // 濡傛灉褰撳墠鏁板瓧澶т簬0锛屽垯涓夋暟涔嬪拰涓�瀹氬ぇ浜�0锛屾墍浠ョ粨鏉熷惊鐜�
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // 鍘婚噸
			int L = i + 1;
			int R = len - 1;
			while (L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if (sum == 0) {
					ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
					while (L < R && nums[L] == nums[L + 1])
						L++; // 鍘婚噸
					while (L < R && nums[R] == nums[R - 1])
						R--; // 鍘婚噸
					L++;
					R--;
				} else if (sum < 0)
					L++;
				else if (sum > 0)
					R--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		ThreeNums a = new ThreeNums();
		a.threeSum(nums);
	}
}
