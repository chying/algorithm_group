package algorithm.chapter3.exe.binsearch;

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
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums != null && nums.length > 0) {
			int lo = 0;
			int hi = nums.length - 1;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				// 正常升序
				if (nums[lo] <= nums[mid] && (nums[lo] > target || target > nums[mid])) {
					lo = mid + 1;
				} else if (nums[lo] > nums[mid] && (nums[lo] > target && nums[mid] < target)) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			}
			if (target == nums[lo]) {
				return lo;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray a = new SearchInRotatedSortedArray();
		int[] nums = new int[] { 5, 1, 3 };

		System.out.println(a.search(nums, 1));
	}

	public int search1(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			// 当[0,mid]有序时,向后规约条件
			if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
				lo = mid + 1;
				// 当[0,mid]发生旋转时，向后规约条件
			} else if (target > nums[mid] && target < nums[0]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo == hi && nums[lo] == target ? lo : -1;
	}

}
