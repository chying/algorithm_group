package algorithm.chapter3.first.binarysearch;

/**
 * 【33. 搜索旋转排序数组】假设按照升序排序的数组在预先未知的某个点上进行了旋转。 (
 * 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。 示例 1: 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author chying
 *
 */
public class LeetCode_33_519 {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if ((nums[mid] - nums[nums.length - 1]) * (target - nums[nums.length - 1]) > 0) {
				if (nums[mid] < target) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			} else if (target > nums[nums.length - 1]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return nums[lo] == target ? lo : -1;
	}

	public int search1(int[] nums, int target) {
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
					: target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

			if (num < target)
				lo = mid + 1;
			else if (num > target)
				hi = mid;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		LeetCode_33_519 a = new LeetCode_33_519();
//		[4,5,6,7,0,1,2]
//		0
		int[] nums = new int[] { 3,1 };
		int target = 1;
		System.out.println(a.search(nums, target));
	}

	public int search2(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// 范围内是否发生了旋转
			if ((nums[mid] - nums[left]) * (nums[right] - nums[mid]) < 0) {
				// 该范围正常是单调递增的 发生反转的在右侧
				if (nums[mid] - nums[left] > 0) {
					if (nums[mid] > target && nums[left] < target) {
						right = mid - 1;
					} else {
						left = mid;
					}
					// 该范围发生了反转 右侧数组单调递增 那么通过比较右侧的最小值与目标值进行比较 如果不在右侧 那么就在左侧
				} else {
					if (nums[mid] > target) {
						left = mid + 1;
					} else {
						left = mid;
					}
				}
				// left和right范围内未发生旋转 正常比较
			} else {
				if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
